package com.sparta.studywebpage.dto;


import com.sparta.studywebpage.model.Comment;
import com.sparta.studywebpage.model.Study;
import com.sparta.studywebpage.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class StudyDetailDto {

    private String studyTitle;
    private String studyContent;
    private String studyAddress;
    private String userNickname;
    private String username;
    private List<CommentResponseDto> commentList;

    public StudyDetailDto(Study study, User user, List<CommentResponseDto> commentList){
        this.studyTitle = study.getTitle();
        this.studyContent = study.getContent();
        this.studyAddress = study.getAddress();
        this.userNickname = user.getNickname();
        this.username = user.getUsername();
        this.commentList = commentList;
    }
}
