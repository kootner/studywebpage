package com.sparta.studywebpage.controller;


import com.sparta.studywebpage.dto.ResponseDto;
import com.sparta.studywebpage.dto.UserRequestDto;
import com.sparta.studywebpage.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody UserRequestDto requestDto) {
        userService.registerUser(requestDto);
        log.info("회원가입 완료");
        return ResponseEntity.ok()
                .body("회원가입 완료");

    }



}
