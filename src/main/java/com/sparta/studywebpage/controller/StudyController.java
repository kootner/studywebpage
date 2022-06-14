package com.sparta.studywebpage.controller;

import com.sparta.studywebpage.dto.ResponseDto;
import com.sparta.studywebpage.dto.StudyRequestDto;
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
    public ResponseEntity<ResponseDto> createStudy(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                                   @RequestBody StudyRequestDto studyRequestDto) {
        User user = userDetails.getUser();
        return studyService.createStudy(studyRequestDto, user);
    }
}
