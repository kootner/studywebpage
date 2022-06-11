package com.sparta.studywebpage.controller;

import com.sparta.studywebpage.dto.CommentRequestDto;
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
    public ResponseEntity<String> createComment(@PathVariable Long studyId,@RequestBody CommentRequestDto commentsRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){

        User user = userDetails.getUser();
        commentService.createComment(studyId,commentsRequestDto,user);

        return ResponseEntity.ok()
                .body("댓글 생성 완료");
    }

    @PutMapping("/putcomment/{commentId}")
    public ResponseEntity<String> updateComment(@PathVariable Long commentId,
                                                @RequestBody CommentRequestDto commentsRequestDto,
                                                @AuthenticationPrincipal UserDetailsImpl userDetails){

        User user = userDetails.getUser();
        commentService.updateComment(commentId,commentsRequestDto,user);

        return ResponseEntity.ok()
                .body("댓글 삭제 완료");
    }

    @DeleteMapping("/deletecomment/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long commentId,
                                                @AuthenticationPrincipal UserDetailsImpl userDetails){
        User user = userDetails.getUser();

        commentService.deleteComment(commentId,user);

        return ResponseEntity.ok()
                .body("댓글 삭제 완료");
    }



}
