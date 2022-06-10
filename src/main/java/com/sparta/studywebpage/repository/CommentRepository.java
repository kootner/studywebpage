package com.sparta.studywebpage.repository;

import com.sparta.studywebpage.model.Comments;
import com.sparta.studywebpage.model.Study;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comments, Long> {

    List<Comments> findAllByStudy(Study study);
}
