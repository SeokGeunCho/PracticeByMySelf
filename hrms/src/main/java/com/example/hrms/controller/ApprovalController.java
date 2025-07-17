package com.example.hrms.controller;

import com.example.hrms.entity.Approval;
import com.example.hrms.service.ApprovalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/approvals")
public class ApprovalController {
    private final ApprovalService approvalService;

    @GetMapping
    public List<Approval> getAllAprovals() {
        return approvalService.findAll();
    }

    @GetMapping("/{id}")
    public Approval getApproval(@PathVariable Long apprNo) {
        return approvalService.findById(apprNo)
                .orElseThrow(() -> new RuntimeException("Not Found"));
    }

    @PostMapping
    public Approval createApproval(@RequestBody Approval approval) {
        return approvalService.save(approval);
    }

    @PutMapping("/{id}")
    public Approval updateApproval(@PathVariable Long apprNo, @RequestBody Approval approval) {
        approval.setApprNo(apprNo);
        return approvalService.save(approval);
    }
    @DeleteMapping("/{id}")
    public void deleteApproval(@PathVariable Long apprNo) {
        approvalService.delete(apprNo);
    }
}
