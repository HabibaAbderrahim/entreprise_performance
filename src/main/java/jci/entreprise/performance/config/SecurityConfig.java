package jci.entreprise.performance.config;

import jci.entreprise.performance.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter ;
    @Autowired
    private JwtAuthorizationFilter jwtAuthorizationFilter ;
    @Autowired
    private UserService userService ;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //TYPES: in Memory / JDBC Authentication(table user is mandatory)
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //desactifer CSRF token (gener automatiquement par spring sec or i will use a JWT token !)
        http.csrf().disable();
        //AS CROSS ORIGINE!!!!!!
        http.cors();
        //change sec Mannagement (Im not using basic web security)
        //Gere session spring security
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //7alit  el la3b 3al login login accesible lel ness el kol
        http.authorizeRequests().antMatchers("/login").permitAll();
        //7alit  el la3b 3al login login accesible lel ness el kol
        http.authorizeRequests().antMatchers("/register").permitAll();
        //bech nal3eb aal access le requet mte3i
        //ay requet apart el login bech tlansiha lezemha authentification
        http.authorizeRequests().anyRequest().authenticated();
        //Add Filters
        http.addFilter(jwtAuthenticationFilter);
        //Add  it after the first filter is done
        http.addFilterAfter(jwtAuthorizationFilter , jwtAuthenticationFilter.getClass());

    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
