package com.example.firstproject.controller;

// 컨트롤러 선언과 동시에 자동으로 임포트

import org.springframework.stereotype.Controller;

// Model 클래스 패키지 자동 임포트
import org.springframework.ui.Model;

// URL 연결 요청(@GetMapping())과 동시에 자동으로 임포트
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 1. 컨트롤러 선언
public class FirstController {

    @GetMapping("/hi") // 1.2. URL 요청 접수
    public String niceToMeetYou(Model model) {  // 2. 메서드 작성  // 3. model 객체 받아오기

        // model 객체가 "홍팍" 값을 "username에 연결해 웹 브라우저로 보냄
        model.addAttribute("username", "석근");
        return "greetings"; // greetings.mustache 파일 변환
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model) {
        model.addAttribute("nickname", "석근");
        return "goodbye";
    }
}
