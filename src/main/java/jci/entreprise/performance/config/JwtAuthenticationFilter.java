package jci.entreprise.performance.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jci.entreprise.performance.entities.User;
import org.mapstruct.BeanMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    //injection des properties
    @Value("${jwt.signin-key}")
    private String signkey;
    @Value("${jwt.header}")
    private String header;
    @Value("${jwt.prefix}")
    private String prefix;
    @Value("${jwt.exp-time}")
    private long expTime;


    //redif method setAuthetf
    @Autowired
    @Override
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        User user = new User();
        //request traja3 json lezem nraj3 objet (user)
        ObjectMapper mapper = new ObjectMapper();

        try {
            user = mapper.readValue(request.getInputStream(), User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.attemptAuthentication(request, response);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        //n7atharhom lel token
        String username = authResult.getName();
        //user can have one or more role
        List<String> authorities = new ArrayList<>();
        authResult.getAuthorities().forEach(role -> {
            authorities.add(role.getAuthority());
        });
        //sna3t tokn
        String token = Jwts.builder().setSubject(username).claim("roles", authorities).setIssuedAt(new Date(System.currentTimeMillis())).
                setExpiration(new Date(System.currentTimeMillis()+ expTime)).signWith(SignatureAlgorithm.HS384, signkey.getBytes()).
                compact();//string

        response.addHeader(header , prefix+token);
    }
}

