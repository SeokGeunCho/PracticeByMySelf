package com.example.hrms.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApprovalDto {
    private Long apprNo;
    private String empNo;
    private String apprKind;
    private String apprTitle;
    private String apprContent;
    private LocalDateTime apprDate;
    private String apprStatus;
    private String apprComment;
    private String apprFile;
    private String docNo;
}
