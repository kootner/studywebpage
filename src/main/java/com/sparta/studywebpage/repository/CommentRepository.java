package com.sparta.studywebpage.repository;

import com.sparta.studywebpage.model.Comment;
import com.sparta.studywebpage.model.Study;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByStudy(Study study);
}
