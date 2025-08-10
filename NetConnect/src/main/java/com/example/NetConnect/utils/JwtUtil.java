package com.example.NetConnect.utils;

import com.example.NetConnect.object.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.time.Duration;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String jwtSecret; // strong random secret, put in env / vault

    private final Duration accessTokenValidity = Duration.ofMinutes(60);

    public String generateAccessToken(User user) {
        Date now = new Date();
        Date expiry = Date.from(now.toInstant().plus(accessTokenValidity));
        return Jwts.builder()
                .setSubject(String.valueOf(user.getId()))
                .claim("username", user.getUserName())
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(Keys.hmacShaKeyFor(jwtSecret.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    public Long getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return Long.valueOf(claims.getSubject());
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret.getBytes()).build().parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}

