package com.example.testsecurity.config;

// 필요한 스프링 시큐리티 관련 클래스들을 불러옵니다.
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// 이 클래스가 설정(Configuration) 클래스임을 알려주는 애너테이션입니다.
@Configuration
// 웹 보안(Web Security)을 활성화하겠다는 뜻입니다.
@EnableWebSecurity
public class SecurityConfig {

    // 이 메서드는 비밀번호를 암호화(안 보이게 바꾸는 것)해주는 도구를 만들어서 스프링이 사용할 수 있도록 등록합니다.
    @Bean  // 스프링이 이 메서드를 보고 자동으로 관리하게 해주는 표시입니다.
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        // BCrypt는 아주 안전한 암호화 방식입니다. 이 객체를 만들어서 비밀번호를 저장할 때나 검사할 때 사용합니다.
        return new BCryptPasswordEncoder();
    }

    // 보안 규칙들을 정의하는 메서드입니다.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // HttpSecurity를 이용하여 각 주소(URL)에 대한 접근 권한을 설정합니다.
        http
                .authorizeHttpRequests((auth) -> auth
                        // "/"와 "/login" 주소는 누구나 접근할 수 있도록 허용합니다.
                        .requestMatchers("/", "/login", "/loginProc", "/join", "/joinProc").permitAll()

                        // "/admin" 주소는 "ADMIN" 역할(Role)을 가진 사용자만 접근할 수 있습니다.
                        .requestMatchers("/admin").hasRole("ADMIN")

                        // "/my/**"로 시작하는 모든 주소는 "ADMIN" 또는 "USER" 역할을 가진 사용자만 접근할 수 있습니다.
                        .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER")

                        // 위에 설정한 것 외의 모든 요청은 로그인한 사용자만 접근할 수 있도록 설정합니다.
                        .anyRequest().authenticated()
                );


        // 로그인 화면 설정을 시작합니다.
        http
                .formLogin((auth) -> auth
                        // 사용자가 직접 만든 로그인 페이지 경로를 지정합니다.
                        // 사용자가 "/login" 주소로 들어오면 로그인 화면이 보입니다.
                        .loginPage("/login")

                        // 로그인 처리를 담당할 URL을 지정합니다.
                        // 사용자가 아이디와 비밀번호를 입력하고 제출하면,
                        // 그 요청은 "/loginProc" 주소로 보내지고, Spring Security가 로그인 처리를 합니다.
                        .loginProcessingUrl("/loginProc")

                        // 로그인 관련 페이지는 로그인하지 않아도 누구나 접근할 수 있도록 허용합니다.
                        .permitAll()
                );

// CSRF 보호 기능을 끕니다.
//        http
//                .csrf((auth) -> auth.disable());

        http
                .sessionManagement((auth) -> auth
                .maximumSessions(1)
                .maxSessionsPreventsLogin(true));

        http
                .sessionManagement((auth) -> auth
                        .sessionFixation().none());

        // 설정한 보안 규칙들을 적용할 수 있도록 SecurityFilterChain 객체를 반환합니다.
        return http.build();
    }

}

