package com.example.authservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity //@Entity: JPA가 관리하는 DB 테이블
// Lombok으로 생성자/Getter/Setter 자동 생성
@Getter
@Setter
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id // @Id + @GeneratedValue: id는 자동 생성되는 PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)    // username: 중복 불가 (unique = true)
    private String username;

    @Column(nullable = false)
    private String password;
}
