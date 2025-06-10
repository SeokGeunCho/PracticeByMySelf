package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor // 생성자 삭제
@NoArgsConstructor // 기본 생성자 추가 어노테이션
@ToString   // ToString 삭제
@Entity // 1. 엔티티 선언
@Getter // getter 추가

public class Article {
    @Id // 3. 엔티티의 대푯값 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 3. 자동 생성 가능 추가(숫자가 자도으로 매겨짐) -> 4.DB가 id 자동 생성
    private Long id;

    @Column // 2. title 필드 선언, DB 테이블의 title 열과 연결됨
    private String title;

    @Column // 2. content 필드 선언, DB 테이블의 content 열과 연결됨
    private String content;

    public void patch(Article article) {
        if (article != null)
            this.title = article.title;
        if (article.content != null)
            this.content = article.content;
    }
}
