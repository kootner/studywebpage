package com.sparta.studywebpage.repository;

import com.sparta.studywebpage.model.Study;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudyRepository extends JpaRepository<Study, Long> {

    Optional<Study> findById(Long id);


}
