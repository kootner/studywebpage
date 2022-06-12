package com.sparta.studywebpage.controller;

import com.sparta.studywebpage.dto.ResponseDto;
import com.sparta.studywebpage.dto.StudyDetailDto;
import com.sparta.studywebpage.dto.StudyDetailRequestDto;
import com.sparta.studywebpage.service.StudyDetailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return studyDetailService.updateStudyDetail(studyid,requestDto);
    }

    @DeleteMapping("/deletestudy/{studyid}")
    public ResponseEntity<ResponseDto> deleteStudyDetail(@PathVariable Long studyid){
       try {
           studyDetailService.deleteStudyDetail(studyid);
       } catch (IllegalArgumentException e) {
           return new ResponseEntity<>(new ResponseDto(false, e.getMessage()), HttpStatus.BAD_REQUEST);
       }
        return new ResponseEntity<>(new ResponseDto(true,"삭제 성공"), HttpStatus.OK);
    }
}
