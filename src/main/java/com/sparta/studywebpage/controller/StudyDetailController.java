package com.sparta.studywebpage.controller;

import com.sparta.studywebpage.dto.StudyDetailDto;
import com.sparta.studywebpage.service.StudyDetailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@RequestMapping("/api")
public class StudyDetailController {

    private final StudyDetailService studyDetailService;

    @GetMapping("/getstudy/{studyid}")
    public StudyDetailDto readStudyDetail(@PathVariable Long studyid){
       return studyDetailService.readStudyDetail(studyid);
    }

}
