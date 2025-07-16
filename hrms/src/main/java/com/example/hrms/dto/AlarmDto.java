package com.example.hrms.dto;

import com.example.hrms.entity.Employee;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlarmDto {

    private Long alarmNo;
    private Employee employee;
    private String alarmContent;
    private LocalDateTime alarmDate;
    private String alarmType;
    private String alarmStatus;
    ;

}
