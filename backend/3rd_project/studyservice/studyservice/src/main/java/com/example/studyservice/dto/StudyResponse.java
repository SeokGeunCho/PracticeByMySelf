package com.example.studyservice.dto;

import com.example.studyservice.domain.Study;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StudyResponse {
    private Long id;
    private String title;
    private String description;
    private String organizer;
    private String category;
    private boolean closed;
    private String status;
    private int maxMembers;

    public static StudyResponse from(Study study) {
        return StudyResponse.builder()
                .id(study.getId())
                .title(study.getTitle())
                .description(study.getDescription())
                .organizer(study.getOrganizer())
                .category(study.getCategory())
                .closed(study.isClosed())
                .status(study.getStatus().name())
                .maxMembers(study.getMaxMembers())
                .build();
    }
}
