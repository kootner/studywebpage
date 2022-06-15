package com.sparta.studywebpage.dto;

import com.sparta.studywebpage.model.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
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
        this.createdAt = commentLocalDateTimeDto.getCreatedAt().format(DateTimeFormatter.ofPattern("MM월 dd일 E요일"));
    }

}
