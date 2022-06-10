package com.sparta.studywebpage.dto;

import com.sparta.studywebpage.model.User;
import lombok.Getter;


@Getter
public class StudyRequestDto {
    private String studyTitle;
    private String studyContent;
    private String studyAddress;
    private User user;
    private String category;
}
