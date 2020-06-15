package com.banque.credit;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.banque.credit.entities.AppUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    //methode utilisé lorsque l'on tente de demander le username
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {
            AppUser ppUser=new ObjectMapper().readValue(request.getInputStream(),AppUser.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            ppUser.getUsername(),ppUser.getPassword()));

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    //il s'agit de la methode utilisé lorsque la saisie sur formulaire correspond au resultat de la bd
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {

        User user= (User) authResult.getPrincipal();
        List<String> role=new ArrayList<>();
        authResult.getAuthorities().forEach(r->{
            role.add(r.getAuthority());
        });

        //ON Créé un JWT
        String jwt= JWT.create()
                .withIssuer(request.getRequestURI())
                .withSubject(user.getUsername())
                .withArrayClaim("role",role.toArray(new String[role.size()]))
                .withExpiresAt(new Date(System.currentTimeMillis()+ SecurityPam.EXPIRATION))

                .sign(Algorithm.HMAC256(SecurityPam.SECRET));
        response.addHeader(SecurityPam.JWT_HEADER_NAME,jwt);

    }
}
