package com.example.studyservice.dto;

import lombok.Getter;

@Getter
public class StudyUpdateRequest {
    private String title;
    private String description;
    private String category;
    private int maxMembers;
}
