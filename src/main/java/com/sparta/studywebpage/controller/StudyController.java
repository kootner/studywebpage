package com.sparta.studywebpage.controller;

import com.sparta.studywebpage.dto.StudyRequestDto;
import com.sparta.studywebpage.model.Study;
import com.sparta.studywebpage.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StudyController {

    private final StudyService studyService;

    @PostMapping("/api/poststudy")
    public void createStudy(@RequestBody StudyRequestDto studyRequestDto){
        studyService.createStudy(studyRequestDto);
    }

    @GetMapping("/api/getstudy/{studyId}")
    public Study readStudy(@PathVariable Long studyId){
        return studyService.readStudy(studyId);
    }

    @PutMapping("/api/putstudy/{studyId}")
    public void updateStudy(@PathVariable Long studyId,@RequestBody StudyRequestDto studyRequestDto) {
        studyService.updateStudy(studyId,studyRequestDto);
    }
}
