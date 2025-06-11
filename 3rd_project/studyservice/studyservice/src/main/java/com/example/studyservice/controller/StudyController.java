package com.example.studyservice.controller;

import com.example.studyservice.dto.StudyCreateRequest;
import com.example.studyservice.dto.StudyResponse;
import com.example.studyservice.dto.StudyUpdateRequest;
import com.example.studyservice.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studies")
@RequiredArgsConstructor
public class StudyController {

    private final StudyService studyService;

    /**
     * 스터디 개설
     */
    @PostMapping
    public ResponseEntity<StudyResponse> createStudy(@RequestBody StudyCreateRequest request) {
        StudyResponse response = studyService.createStudy(request);
        return ResponseEntity.ok(response);
    }

    /**
     * 전체 스터디 조회
     */
    @GetMapping
    public ResponseEntity<List<StudyResponse>> getAllStudies() {
        return ResponseEntity.ok(studyService.getAllStudies());
    }

    /**
     * 단일 스터디 조회
     */
    @GetMapping("/{id}")
    public ResponseEntity<StudyResponse> getStudyById(@PathVariable Long id) {
        return ResponseEntity.ok(studyService.getStudyById(id));
    }

    /**
     * 스터디 마감
     */
    @PutMapping("/{id}/close")
    public ResponseEntity<Void> closeStudy(@PathVariable Long id) {
        studyService.closeStudy(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * 스터디 수정
     */
    @PutMapping("/{id}")
    public ResponseEntity<StudyResponse> updateStudy(@PathVariable Long id, @RequestBody StudyUpdateRequest request) {
        StudyResponse response = studyService.updateStudy(id, request);
        return ResponseEntity.ok(response);
    }

    /**
     * 스터디 삭제
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudy(@PathVariable Long id) {
        studyService.deleteStudy(id);
        return ResponseEntity.noContent().build();
    }
}
