package com.restaurantsProject.project.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
public class JWTUsernamePasswordFilter extends UsernamePasswordAuthenticationFilter {


    private final AuthenticationManager authenticationManager;

    private final JWTConfig jwtConfig;



    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            JWTModel jwtModel = new ObjectMapper()
                    .readValue(request.getInputStream(), JWTModel.class);

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    jwtModel.getUsername(),
                    jwtModel.getPassword()
            );

            Authentication authenticate = authenticationManager.authenticate(authentication);
            return authenticate;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication auth) throws IOException, ServletException {

        String username = ((User) auth.getPrincipal()).getUsername();

        String token = Jwts.builder()
                .setSubject(username)
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(jwtConfig.getTokenExpirationAfterDays())))
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256 , jwtConfig.getSecretKey())
                .compact();


        response.setHeader(jwtConfig.getAuthorizationHeader(), jwtConfig.getTokenPrefix() + " " +token);

    }
}
