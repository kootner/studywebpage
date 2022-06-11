package com.sparta.studywebpage.dto;

import com.sparta.studywebpage.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class StudyRequestDto {
    private String studyTitle;
    private String studyContent;
    private String studyAddress;
    private String category;
    private User user;
}
