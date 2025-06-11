package com.example.studyservice.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Study {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;            // 스터디 제목
    private String description;      // 설명
    private String organizer;        // 개설자 이름
    private boolean closed;          // 마감 여부

    @Enumerated(EnumType.STRING)
    private StudyStatus status;      // 상태 (OPEN, CLOSED)

    private String category;         // ex) Java, Spring, SQL 등

    private int maxMembers;          // 최대 인원 수
}
