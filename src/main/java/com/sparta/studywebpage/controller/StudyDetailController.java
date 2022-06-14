package com.sparta.studywebpage.controller;

import com.sparta.studywebpage.dto.ResponseDto;
import com.sparta.studywebpage.dto.StudyDetailDto;
import com.sparta.studywebpage.dto.StudyDetailRequestDto;
import com.sparta.studywebpage.security.UserDetailsImpl;
import com.sparta.studywebpage.service.StudyDetailService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/api")
@RestController
public class StudyDetailController {

    private final StudyDetailService studyDetailService;

    @GetMapping("/getstudy/{studyid}")
    public StudyDetailDto readStudyDetail(@PathVariable Long studyid) {
        return studyDetailService.readStudyDetail(studyid);
    }

    @PutMapping("/putstudy/{studyid}")
    public ResponseEntity<ResponseDto> updateStudyDetail(@PathVariable Long studyid, @RequestBody StudyDetailRequestDto requestDto) {
        return studyDetailService.updateStudyDetail(studyid, requestDto);
    }

    @DeleteMapping("/deletestudy/{studyid}")
    public ResponseEntity<ResponseDto> deleteStudyDetail(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long studyid) {
        return studyDetailService.deleteStudyDetail(studyid, userDetails);
    }
}
