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

    private String userNickname;
    private String username;
    private String commentContent;
    private Long commentId;

    public CommentResponseDto(Comment commentContent){
        this.userNickname = commentContent.getUser().getNickname();
        this.username = commentContent.getUser().getUsername();
        this.commentContent = commentContent.getComment();
        this.commentId = commentContent.getId();
    }

}
