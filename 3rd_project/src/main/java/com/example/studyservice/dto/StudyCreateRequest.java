package com.example.studyservice.dto;

import lombok.Getter;

@Getter
public class StudyCreateRequest {
    private String title;
    private String description;
    private String organizer;
    private String category;
    private int maxMembers;
}
