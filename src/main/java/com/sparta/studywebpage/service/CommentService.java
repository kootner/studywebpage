package com.sparta.studywebpage.service;

import com.sparta.studywebpage.dto.CommentRequestDto;
import com.sparta.studywebpage.exception.CustomException;
import com.sparta.studywebpage.exception.ErrorCode;
import com.sparta.studywebpage.model.Comment;
import com.sparta.studywebpage.model.Study;
import com.sparta.studywebpage.model.User;
import com.sparta.studywebpage.repository.CommentRepository;
import com.sparta.studywebpage.repository.StudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final StudyRepository studyRepository;


    @Transactional
    public void createComment(Long studyId, CommentRequestDto commentsRequestDto, User user) {
        Comment comment = new Comment(commentsRequestDto);
        Study study = studyRepository.findById(studyId).orElseThrow(()->new CustomException(ErrorCode.NOT_FOUND_STUDY));

        comment.setStudy(study);
        comment.setUser(user);

        commentRepository.save(comment);

    }
    @Transactional
    public void updateComment(Long commentId, CommentRequestDto commentRequestDto, User user) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(()->new CustomException(ErrorCode.NOT_FOUND_COMMENT));
        if(!user.getId().equals(comment.getUser().getId())){
            throw new CustomException(ErrorCode.WRONG_USER);
        }
        comment.setComment(commentRequestDto.getComment());
        commentRepository.save(comment);
    }

    @Transactional
    public void deleteComment(Long commentId, User user) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(()->new CustomException(ErrorCode.NOT_FOUND_COMMENT));
        if(!user.getId().equals(comment.getUser().getId())){
            throw new CustomException(ErrorCode.WRONG_USER);
        }
        commentRepository.delete(comment);
    }
}
