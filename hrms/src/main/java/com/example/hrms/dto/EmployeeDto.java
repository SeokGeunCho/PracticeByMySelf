package com.example.hrms.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {

    private String empNo;
    private String empName;
    private String deptCode;
    private String empEmail;
    private String empPw;
    private LocalDateTime joinDate;
}
