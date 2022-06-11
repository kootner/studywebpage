package com.sparta.studywebpage.dto;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
public class MainPageSearchDto {

    String nickname;

    String title;
}
