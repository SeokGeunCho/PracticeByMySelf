package com.example.hrms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    @Id
    private String empNo;

    private String empName;
    private String deptCode;
    private String empEmail;
    private String empPw;
    private LocalDateTime joinDate;
}
