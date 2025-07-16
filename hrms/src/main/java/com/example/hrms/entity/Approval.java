package com.example.hrms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "approval")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Approval {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long apprNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_no")
    private Employee employee; // 결재자

    private String apprKind;
    private String apprTitle;

    @Lob
    private String apprContent;

    private LocalDateTime apprDate;
    private String apprStatus;
    private String apprComment;
    private String apprFile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_no")
    private Document document;
}
