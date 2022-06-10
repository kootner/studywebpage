package com.sparta.studywebpage.repository;

import com.sparta.studywebpage.model.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study, Long> {
}
