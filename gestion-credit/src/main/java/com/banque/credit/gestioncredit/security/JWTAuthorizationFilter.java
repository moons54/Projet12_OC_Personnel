package com.banque.credit.gestioncredit.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JWTAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method,Acces-Control-Request-Headers,authorization");
        response.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin,Access-Control-Allow-Credentials,authorization");
        response.addHeader("Access-Control-Allow-Methods","GET,POST,DELETE,PUT,PATCH");
        if (request.getMethod().equals("OPTIONS ")) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            //On réccupère notre JWT

            String jwt = request.getHeader(SecurityPam.JWT_HEADER_NAME);

            //Nous effectuons les tests
            //si jwt est null ou ne commence pas par le préfix on passe au
            //filtre suivant
            if (jwt == null || !jwt.startsWith(SecurityPam.HEADER_PREFIX)) {
                filterChain.doFilter(request, response);
                return;
            }
            //on verifie la signature avec le codesecret
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SecurityPam.SECRET)).build();


            //auxquel cas on décode
            DecodedJWT decodedJWT = verifier.verify(jwt.substring(SecurityPam.HEADER_PREFIX.length()));

            //on decode et on reccupere les valeurs
            String username = decodedJWT.getSubject();

            List<String> roles = decodedJWT.getClaims().get("role").asList(String.class);

            Collection<GrantedAuthority> authorities = new ArrayList<>();

            roles.forEach(rn -> {
                authorities.add(new SimpleGrantedAuthority(rn));
            });
            //on utilise le user de spring puis ensuite on l'authentifie
            UsernamePasswordAuthenticationToken user =
                    new UsernamePasswordAuthenticationToken(username, null, authorities);

            SecurityContextHolder.getContext().setAuthentication(user);
            filterChain.doFilter(request, response);
        }
    }

}
