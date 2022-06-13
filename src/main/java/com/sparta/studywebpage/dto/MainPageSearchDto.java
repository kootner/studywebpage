package com.sparta.studywebpage.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
@Setter
@Getter
public class MainPageSearchDto {

    String nickname;

    String title;

    String category;

    Long id;
}
