package com.sparta.studywebpage.dto;

import com.sparta.studywebpage.model.Study;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
@Setter
@Getter
public class MainPageSearchDto {

     String studyTitle;
     String userNickname;
     String category;
//     String imageUrl;
     Long studyId;


     public MainPageSearchDto(Study study) {
          this.studyTitle = study.getTitle();
          this.userNickname = study.getUser().getNickname();
//          this.imageUrl = study.getImageUrl();
          this.category = study.getCategory();
          this.studyId = study.getId();
     }
}