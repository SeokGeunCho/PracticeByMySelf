package com.example.gateway_service.filter;

import com.example.gateway_service.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter implements GlobalFilter {

    private final JwtUtil jwtUtil;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getURI().getPath();
        System.out.println("📌 Gateway 요청 경로: " + path);

        // ✅ /auth 또는 /auth/** 경로는 인증 제외
        if (path.equals("/auth") || path.startsWith("/auth/")) {
            System.out.println("✅ 인증 제외 경로: " + path);
            return chain.filter(exchange);
        }

        // ✅ Authorization 헤더 가져오기
        String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            System.out.println("❌ Authorization 헤더 없음 또는 형식 오류");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        // ✅ 토큰 검증
        String token = authHeader.substring(7); // "Bearer " 제외

        try {
            String username = jwtUtil.validateTokenAndGetUsername(token);
            System.out.println("✅ JWT 유효: " + username);
        } catch (Exception e) {
            System.out.println("❌ JWT 검증 실패: " + e.getMessage());
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        // ✅ 인증 통과
        System.out.println("✅ 인증 통과 → 다음 필터로");
        return chain.filter(exchange);
    }
}
