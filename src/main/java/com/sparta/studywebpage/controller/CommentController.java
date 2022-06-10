package com.sparta.studywebpage.controller;

import com.sparta.studywebpage.dto.CommentRequestDto;
import com.sparta.studywebpage.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentsService;


    @PostMapping("/postcomment/{studyId}")
    public ResponseEntity<String> createComment(@PathVariable Long studyId, CommentRequestDto commentsRequestDto,){
        commentsService.createComment(studyId,commentsRequestDto,user);


        return ResponseEntity.ok()
                .body("댓글 생성 완료");
    }

}
