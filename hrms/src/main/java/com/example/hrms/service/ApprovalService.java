package com.example.hrms.service;

import com.example.hrms.entity.Approval;
import com.example.hrms.repository.ApprovalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApprovalService {
    private final ApprovalRepository approvalRepository;

    public List<Approval> findAll() {
        return approvalRepository.findAll();
    }

    public Optional<Approval> findById(Long id) {
        return approvalRepository.findById(id);
    }

    public Approval save(Approval approval) {
        return approvalRepository.save(approval);
    }

    public void delete(Long id) {
        approvalRepository.deleteById(id);
    }
}
