package com.example.hrms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "alarm")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Alarm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alarmNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_no")
    private Employee employee;

    private String alarmContent;
    private LocalDateTime alarmDate;
    private String alarmType;
    private String alarmStatus;
}
