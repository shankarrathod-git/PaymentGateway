package com.paymentGateway.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {
    private static final String SECRET = "MySecretKeyForPaymentGatewayApplicationJWT123456";
    private static final Key KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    public String generateToken(String username){
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000 * 60 * 60))
                .signWith(KEY)
                .compact();
    }
    public String extractUsername(String token) {

        return Jwts.parser()
                .verifyWith((javax.crypto.SecretKey) KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
}
