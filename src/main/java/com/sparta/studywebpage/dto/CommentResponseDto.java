package com.sparta.studywebpage.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
public class CommentResponseDto {

    private String userNickname;
    private String username;
    private String commentContent;
    private Long commentId;

    private String createdAt;

    public CommentResponseDto(CommentLocalDateTimeDto commentLocalDateTimeDto){
        this.userNickname = commentLocalDateTimeDto.getUserNickname();
        this.username = commentLocalDateTimeDto.getUsername();
        this.commentContent = commentLocalDateTimeDto.getCommentContent();
        this.commentId = commentLocalDateTimeDto.getCommentId();
        this.createdAt = commentLocalDateTimeDto.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
    }

}
