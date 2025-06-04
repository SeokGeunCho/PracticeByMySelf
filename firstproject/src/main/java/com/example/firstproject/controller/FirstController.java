package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 1. 컨트롤러 요청 받는다.
public class FirstController {

    @GetMapping("/hi") // 3. html과 연결 시켜줘야 한다.
    public String niceToMeetYou(Model model) { //
        model.addAttribute("username", "hongpark"); // 4. greetings.mustache 안에 있는 {{username}} 템플릿 변수를 사용하기 위한 모델 등록
        return "greetings"; // 2. 리턴값 설정 : templates/greetings.mustache -> 브라우저로 전송!
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model) {
        model.addAttribute("nickname", "홍길동");
        return "goodbye";
    }
}
