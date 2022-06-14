package com.sparta.studywebpage.dto;


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

}
