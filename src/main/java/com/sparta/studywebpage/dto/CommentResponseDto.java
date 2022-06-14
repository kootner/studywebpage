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
    private String commentContent;
    private Long commentId;
    private LocalDateTime createdAt;

    public CommentResponseDto(Comment commentContent){
        this.user = commentContent.getUser();
        this.commentContent = commentContent.getComment();
        this.commentId = commentContent.getId();
        this.createdAt = commentContent.getCreatedAt();
    }

}
