// 클라이언트가 보내는 JSON 데이터를 받을 DTO 클래스입니다.

package com.example.jwtlogin.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinDTO {
    private String username;
    private String password;
}
