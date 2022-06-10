package com.sparta.studywebpage.controller;


import com.sparta.studywebpage.dto.UserRequestDto;
import com.sparta.studywebpage.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @

    @PostMapping("/signip")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserRequestDto requestDto) {
        userService.registerUser(requestDto);
        log.info("회원가입 완료");
        return ResponseEntity.ok()
                .body("회원가입 완료");
    }

}
