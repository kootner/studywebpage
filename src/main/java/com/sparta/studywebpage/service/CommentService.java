package com.sparta.studywebpage.service;

import com.sparta.studywebpage.dto.CommentRequestDto;
import com.sparta.studywebpage.dto.ResponseDto;
import com.sparta.studywebpage.exception.CustomException;
import com.sparta.studywebpage.exception.ErrorCode;
import com.sparta.studywebpage.model.Comment;
import com.sparta.studywebpage.model.Study;
import com.sparta.studywebpage.model.User;
import com.sparta.studywebpage.repository.CommentRepository;
import com.sparta.studywebpage.repository.StudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final StudyRepository studyRepository;


    @Transactional
    public ResponseEntity<ResponseDto> createComment(Long studyId, CommentRequestDto commentsRequestDto, User user) {
        Comment comment = new Comment(commentsRequestDto);
        Study study = studyRepository.findById(studyId).orElse(null);

        if(study == null)
            return new ResponseEntity<>(new ResponseDto(false,"등록 실패"), HttpStatus.BAD_REQUEST);

        comment.setStudy(study);
        comment.setUser(user);

        commentRepository.save(comment);
        return new ResponseEntity<>(new ResponseDto(true,"작성 성공"), HttpStatus.OK);
    }
    @Transactional
    public ResponseEntity<ResponseDto> updateComment(Long commentId, CommentRequestDto commentRequestDto, User user) {
        Comment comment = commentRepository.findById(commentId).orElse(null);
        if (comment == null) {
            return new ResponseEntity<>(new ResponseDto(false, "수정 실패"), HttpStatus.BAD_REQUEST);
        }
        if(!user.getId().equals(comment.getUser().getId())) {
            return new ResponseEntity<>(new ResponseDto(false,"수정 실패"), HttpStatus.BAD_REQUEST);
        }
        comment.setComment(commentRequestDto.getComment());
        commentRepository.save(comment);
        return new ResponseEntity<>(new ResponseDto(true,"수정 성공"), HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<ResponseDto> deleteComment(Long commentId, User user) {
        Comment comment = commentRepository.findById(commentId).orElse(null);
        if (comment == null) {
            return new ResponseEntity<>(new ResponseDto(false, "삭제 실패"), HttpStatus.BAD_REQUEST);
        }
        if(!user.getId().equals(comment.getUser().getId())){
            return new ResponseEntity<>(new ResponseDto(false, "삭제 실패"), HttpStatus.BAD_REQUEST);
        }
        commentRepository.delete(comment);
        return new ResponseEntity<>(new ResponseDto(true,"삭제 성공"), HttpStatus.OK);
    }
}
