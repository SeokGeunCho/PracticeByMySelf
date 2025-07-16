package com.example.hrms.dto;

import com.example.hrms.entity.Employee;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentDto {

    private String docNo;
    private String docName;
    private String docForm;
    private String docContent;
    private Employee docWriter;
    private LocalDateTime docDate;
}
