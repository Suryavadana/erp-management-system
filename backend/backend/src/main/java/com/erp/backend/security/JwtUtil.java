package com.erp.backend.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private static final long EXPIRATION_TIME = 1000 * 60 * 60; //1hour
    private static final Key key = Keys.secretKeyFor( SignatureAlgorithm.HS256 ); //HS256 industry standard
   // private final String jwtSecret="my-super-secret-key-for-jwt-token-generation-erp-project";

    //private final long jwtExpirationMs= 24 * 60 * 60 * 1000; // 1day
//    private Key getSigningKey(){
//        return Keys.hmacShaKeyFor( jwtSecret.getBytes());
//    }
    public Key getKey() {
        return key;
    }
    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username) //identifies user
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
                .signWith( key)
                .compact();
    }

}
