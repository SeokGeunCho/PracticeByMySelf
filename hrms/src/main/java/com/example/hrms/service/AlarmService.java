package com.example.hrms.service;

import com.example.hrms.entity.Alarm;
import com.example.hrms.repository.AlarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlarmService {
    private final AlarmRepository alarmRepository;

    public List<Alarm> findAll() {
        return alarmRepository.findAll();
    }

    public Optional<Alarm> findById(Long alarmNo) {
        return alarmRepository.findById(alarmNo);
    }

    public Alarm save(Alarm alarm) {
        return alarmRepository.save(alarm);
    }
    public void delete(Long alarmNo) {
        alarmRepository.deleteById(alarmNo);
    }
}
