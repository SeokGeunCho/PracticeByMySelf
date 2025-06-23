package com.example.authservice.repository;

import com.example.authservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// User 엔티티를 관리하고, id 타입은 Long
public interface UserRepository extends JpaRepository<User, Long> {
    // 	로그인 시 사용자가 입력한 아이디로 검색하려고 만듦
    //  값이 없을 수도 있으니 Optional로 감싸줌 (null 처리 안전)
    Optional<User> findByUsername(String username);
}
