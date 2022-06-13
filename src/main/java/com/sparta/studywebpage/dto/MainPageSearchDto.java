package com.sparta.studywebpage.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
@Setter
@Getter
public class MainPageSearchDto {

     String studyTitle;
     String userNickname;
     String category;
     Long studyId;
}