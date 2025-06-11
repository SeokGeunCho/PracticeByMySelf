package com.example.studyservice.repository;

import com.example.studyservice.domain.Study;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyRepository extends JpaRepository<Study, Long> {

    // 마감되지 않은 스터디만 조회
    List<Study> findByClosedFalse();

    // 특정 상태의 스터디만 조회 (예: OPEN)
    List<Study> findByStatus(String status);
}
