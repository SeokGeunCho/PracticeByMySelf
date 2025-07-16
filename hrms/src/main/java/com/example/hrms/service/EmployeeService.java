package com.example.hrms.service;

import com.example.hrms.entity.Employee;
import com.example.hrms.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
    public Optional<Employee> findById(String empNo) {
        return employeeRepository.findById(empNo);
    }
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
    public void delete(String empNo) {
        employeeRepository.deleteById(empNo);
    }
}
