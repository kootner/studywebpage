package com.sparta.studywebpage.dto;


import com.sparta.studywebpage.model.Comment;
import com.sparta.studywebpage.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CommentResponseDto {

    private User user;
    private String comment;
    private LocalDateTime createdAt;

    public CommentResponseDto(Comment comment){
        this.user = comment.getUser();
        this.comment = comment.getComment();
        this.createdAt = comment.getCreatedAt();
    }

}
