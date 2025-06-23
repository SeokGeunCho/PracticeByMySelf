package com.example.jwtlogin.controller;

import com.example.jwtlogin.service.JoinService;
import com.example.jwtlogin.dto.JoinDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class JoinController {
    private final JoinService joinService;

    @PostMapping("/join")
    public String join(@RequestBody JoinDTO joinDTO){
        joinService.join(joinDTO);
        return "회원가입 완료!";
    }
}
