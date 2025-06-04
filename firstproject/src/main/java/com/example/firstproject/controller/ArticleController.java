package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create") // /articles/create 로 받는다.
    public String createArticle(ArticleForm form) {  // DTO  ArticleForm form 에 담겨진다.
        System.out.println(form.toString());
        return "";
    }

}
