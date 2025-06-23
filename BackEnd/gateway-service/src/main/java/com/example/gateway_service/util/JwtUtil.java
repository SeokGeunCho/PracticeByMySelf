package com.example.gateway_service.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;

@Component
public class JwtUtil {

    // ✅ auth-service와 완전히 동일한 키로 변경
    private final String rawSecret = "my-super-secure-jwt-secret-key-1234"; // 완벽히 맞춰야 함
    private SecretKey key;

    @PostConstruct
    public void init() {
        // Base64 인코딩 후 디코딩 → SecretKey 생성
        String base64Key = Base64.getEncoder().encodeToString(rawSecret.getBytes());
        key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(base64Key));
    }

    public String validateTokenAndGetUsername(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getSubject();
        } catch (JwtException e) {
            throw new RuntimeException("JWT 검증 실패: " + e.getMessage());
        }
    }
}
