package com.example.portfolio_tracker.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;


@Component
public class JwtUtils {
    private final SecretKey jwtSecret = Keys.secretKeyFor(SignatureAlgorithm.HS256);


    @Value("${app.jwt.expiration.ms}")
    private int jwtExpirationMs;


    public String generateAccessToken(UserDetails userDetails) {
        System.out.println("Генерация аксес");
        try {
            String accessToken = Jwts.builder()
                    .setSubject(userDetails.getUsername())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs)) // 15 минут
                    .signWith(jwtSecret)
                    .compact();
            return accessToken;
        } catch (Exception e) {
            System.out.println("Ошибка генерации аксес токена: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    public String generateRefreshToken(UserDetails userDetails) {
        System.out.println("Генерация рефрещ");
        try {
            return Jwts.builder()
                    .setSubject(userDetails.getUsername())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000)) // 7 дней
                    .signWith(jwtSecret)
                    .compact();
        } catch (Exception e){
            System.out.println("Ошибка генерации рефреш токена: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    public String getUsernameFromToken(String token){
        return Jwts.parserBuilder()
                .setSigningKey(jwtSecret)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token, UserDetails userDetails){
        String username = getUsernameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        try {
            Date expiration = Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(token)
                    .getBody()
                    .getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return true;
        }
    }

}
