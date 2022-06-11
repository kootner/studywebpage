package com.sparta.studywebpage.controller;

import com.sparta.studywebpage.dto.StudyRequestDto;
import com.sparta.studywebpage.model.Study;
import com.sparta.studywebpage.model.User;
import com.sparta.studywebpage.security.UserDetailsImpl;
import com.sparta.studywebpage.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StudyController {

    private final StudyService studyService;

    @PostMapping("/api/poststudy")
    public ResponseEntity<String> createStudy(@RequestBody StudyRequestDto studyRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        User user = userDetails.getUser();
        studyService.createStudy(studyRequestDto,user);

        return ResponseEntity.ok()
                .body("상세페이지 등록 성공");
    }

    @GetMapping("/api/getstudy/{studyId}")
    public Study readStudy(@PathVariable Long studyId){
        return studyService.readStudy(studyId);
    }

    @PutMapping("/api/putstudy/{studyId}")
    public ResponseEntity<String> updateStudy(@PathVariable Long studyId,@RequestBody StudyRequestDto studyRequestDto) {
        studyService.updateStudy(studyId,studyRequestDto);

        return ResponseEntity.ok()
                .body("상세페이지 수정 성공");
    }

    @DeleteMapping("/api/deletestudy/{studyId}")
    public ResponseEntity<String> deleteStudy(@PathVariable Long studyId){
        studyService.deleteStudy(studyId);

        return ResponseEntity.ok()
                .body("상세페이지 수정 성공");
    }
}
