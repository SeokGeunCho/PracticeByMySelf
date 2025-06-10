package com.example.parrotProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    public String niceToMeetYou(Model model) {
        model.addAttribute("username", "석근");
        return "greetings";
    }
    @GetMapping("/bye")
    public String seeYouNextTime(Model model) {
        model.addAttribute("nickname","석근");
        return "goodbye";
    }
}
