package com.br.EAD.security.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.br.EAD.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String secret;

    public String generateToken(User user){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("authentication-ead")
                    .withSubject(user.getEmail())
                    .withExpiresAt(generationExpirationDate())
                    .withClaim("profiles", user.getProfile().name())
                    .sign(algorithm);
        }catch (JWTCreationException e){
            e.printStackTrace();
            return "Error while generating token";
        }
    }

    public DecodedJWT validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("authentication-ead")
                    .build()
                    .verify(token);
        }catch (JWTVerificationException e){
            e.printStackTrace();
            return null;
        }
    }
    private Instant generationExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
