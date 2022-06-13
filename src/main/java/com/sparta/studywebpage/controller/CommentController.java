package com.sparta.studywebpage.controller;

import com.sparta.studywebpage.dto.CommentRequestDto;
import com.sparta.studywebpage.dto.ResponseDto;
import com.sparta.studywebpage.model.User;
import com.sparta.studywebpage.security.UserDetailsImpl;
import com.sparta.studywebpage.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;


    @PostMapping("/postcomment/{studyId}")
    public ResponseEntity<ResponseDto> createComment(@PathVariable Long studyId,
                                                     @RequestBody CommentRequestDto commentsRequestDto,
                                                     @AuthenticationPrincipal UserDetailsImpl userDetails){
        User user = userDetails.getUser();

        return commentService.createComment(studyId,commentsRequestDto,user);
    }

    @PutMapping("/putcomment/{commentId}")
    public ResponseEntity<ResponseDto> updateComment(@PathVariable Long commentId,
                                                @RequestBody CommentRequestDto commentsRequestDto,
                                                @AuthenticationPrincipal UserDetailsImpl userDetails){
        User user = userDetails.getUser();

        return commentService.updateComment(commentId,commentsRequestDto,user);
    }

    @DeleteMapping("/deletecomment/{commentId}")
    public ResponseEntity<ResponseDto> deleteComment(@PathVariable Long commentId,
                                                     @AuthenticationPrincipal UserDetailsImpl userDetails){
        User user = userDetails.getUser();

        return commentService.deleteComment(commentId,user);
    }



}
