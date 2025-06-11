package com.example.studyservice.service;

import com.example.studyservice.domain.Study;
import com.example.studyservice.domain.StudyStatus;
import com.example.studyservice.dto.StudyCreateRequest;
import com.example.studyservice.dto.StudyResponse;
import com.example.studyservice.dto.StudyUpdateRequest;
import com.example.studyservice.exception.StudyNotFoundException;
import com.example.studyservice.repository.StudyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j  // ✅ 로그 사용을 위한 Lombok 어노테이션
@Service
@RequiredArgsConstructor
public class StudyService {

    private final StudyRepository studyRepository;

    /**
     * 스터디 개설
     */
    public StudyResponse createStudy(StudyCreateRequest request) {
        Study study = Study.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .organizer(request.getOrganizer())
                .category(request.getCategory())
                .maxMembers(request.getMaxMembers())
                .closed(false)
                .status(StudyStatus.OPEN)
                .build();

        Study saved = studyRepository.save(study);
        log.info("✅ 스터디가 생성되었습니다. [id={}, title={}]", saved.getId(), saved.getTitle());
        return StudyResponse.from(saved);
    }

    /**
     * 전체 스터디 목록 조회
     */
    public List<StudyResponse> getAllStudies() {
        return studyRepository.findAll().stream()
                .map(StudyResponse::from)
                .collect(Collectors.toList());
    }

    /**
     * 특정 ID의 스터디 상세 조회
     */
    public StudyResponse getStudyById(Long id) {
        Study study = studyRepository.findById(id)
                .orElseThrow(() -> new StudyNotFoundException(id));
        return StudyResponse.from(study);
    }

    /**
     * 스터디 마감 처리
     */
    public void closeStudy(Long id) {
        Study study = studyRepository.findById(id)
                .orElseThrow(() -> new StudyNotFoundException(id));

        study.setClosed(true);
        study.setStatus(StudyStatus.CLOSED);
        studyRepository.save(study);

        log.info("🔒 스터디가 마감되었습니다. [id={}, title={}]", study.getId(), study.getTitle());
    }

    /**
     * 스터디 수정
     */
    public StudyResponse updateStudy(Long id, StudyUpdateRequest request) {
        Study study = studyRepository.findById(id)
                .orElseThrow(() -> new StudyNotFoundException(id));

        study.setTitle(request.getTitle());
        study.setDescription(request.getDescription());
        study.setCategory(request.getCategory());
        study.setMaxMembers(request.getMaxMembers());

        Study updated = studyRepository.save(study);
        log.info("✏️ 스터디를 수정하였습니다. [id={}, title={}]", updated.getId(), updated.getTitle());
        return StudyResponse.from(updated);
    }

    /**
     * 스터디 삭제
     */
    public void deleteStudy(Long id) {
        Study study = studyRepository.findById(id)
                .orElseThrow(() -> new StudyNotFoundException(id));

        studyRepository.delete(study);
        log.info("🗑️ 스터디가 삭제되었습니다. [id={}, title={}]", study.getId(), study.getTitle());
    }
}
