package jci.entreprise.performance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

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

    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();

    }

}
