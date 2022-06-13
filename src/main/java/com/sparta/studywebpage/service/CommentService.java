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
        String comment1 = commentsRequestDto.getComment();
        Study study = studyRepository.findById(studyId).orElse(null);
        Comment comment = new Comment(comment1,user,study);
        if(study == null){
            return  checkIdAction("등록");
        }
        commentRepository.save(comment);
        return successAction("등록");
    }

    @Transactional
    public ResponseEntity<ResponseDto> updateComment(Long commentId, CommentRequestDto commentRequestDto, User user) {
        Comment comment = commentRepository.findById(commentId).orElse(null);
        if (comment == null) {
            return checkIdAction("수정");
        }
        if(!user.getId().equals(comment.getUser().getId())) {
            return checkIdAction("수정");
        }
        comment.update(commentRequestDto.getComment());
        commentRepository.save(comment);
        return successAction("수정");
    }

    @Transactional
    public ResponseEntity<ResponseDto> deleteComment(Long commentId, User user) {
        Comment comment = commentRepository.findById(commentId).orElse(null);
        if (comment == null) {
           return checkIdAction("삭제");
        }
        if(!user.getId().equals(comment.getUser().getId())){
            return  checkIdAction("삭제");
        }
        commentRepository.delete(comment);
        return successAction("삭제");
    }

    public ResponseEntity<ResponseDto> checkIdAction (String action){
        return new ResponseEntity<>(new ResponseDto(false, action+" 실패"), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ResponseDto> successAction (String action){
        return new ResponseEntity<>(new ResponseDto(true, action+" 성공"), HttpStatus.OK);
    }
}
