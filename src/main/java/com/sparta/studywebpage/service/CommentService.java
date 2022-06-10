package com.sparta.studywebpage.service;

import com.sparta.studywebpage.dto.CommentRequestDto;
import com.sparta.studywebpage.exception.CustomException;
import com.sparta.studywebpage.exception.ErrorCode;
import com.sparta.studywebpage.model.Comment;
import com.sparta.studywebpage.model.Study;
import com.sparta.studywebpage.repository.CommentRepository;
import com.sparta.studywebpage.repository.StudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private CommentRepository commentRepository;
    private StudyRepository studyRepository;
    public void createComment(Long studyId, CommentRequestDto commentsRequestDto,String user) {
        Comment comment = new Comment(commentsRequestDto);
        Study study = studyRepository.findById(studyId).orElseThrow(()->new CustomException(ErrorCode.NOT_FOUND_COMMENT));

        comment.setStudy(study);
        comment.setUser();
    }
}
