package com.banque.credit.gestioncredit.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {
       // super.configure(http);
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //http.authorizeRequests().antMatchers("/clients/**").hasAuthority("ADMIN");
        //toutes les autres entrée doivent être authentifé
      //  http.authorizeRequests().anyRequest().authenticated();
        //donne accés a toutes les entrées
         http.authorizeRequests().anyRequest().permitAll();
    //    http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

   /* @Bean
            public BCryptPasswordEncoder getBcrypt(){
        return new BCryptPasswordEncoder();
    }
*/

}
