package com.example.hrms.controller;


import com.example.hrms.entity.Alarm;
import com.example.hrms.service.AlarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alarms")
@RequiredArgsConstructor
public class AlarmController {
    private final AlarmService alarmService;

    @GetMapping
    public List<Alarm> getAllAlarms() {
        return alarmService.findAll();
    }

    @GetMapping("/{id}")
    public Alarm getAlarm(@PathVariable Long alarmNo){
        return alarmService.findById(alarmNo)
                .orElseThrow(() -> new RuntimeException("Not Found"));
    }

    @PostMapping
    public Alarm createAlarm(@RequestBody Alarm alarm) {
        return alarmService.save(alarm);
    }

    @PostMapping("/{id}")
    public Alarm updateAlarm(@PathVariable Long alarmNo, @RequestBody Alarm alarm) {
        alarm.setAlarmNo(alarmNo);
        return alarmService.save(alarm);
    }
    @DeleteMapping("/{id}")
    public void deleteAlarm(@PathVariable Long alarmNo){
        alarmService.delete(alarmNo);
    }
}
