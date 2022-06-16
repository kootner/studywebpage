package com.sparta.studywebpage.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.sparta.studywebpage.dto.KakaoUserResponseDto;
import com.sparta.studywebpage.dto.ResponseDto;
import com.sparta.studywebpage.dto.UserRequestDto;
import com.sparta.studywebpage.service.KakaoUserService;
import com.sparta.studywebpage.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    private final KakaoUserService kakaoUserService;


    @PostMapping("/signup")
    public ResponseEntity<ResponseDto> registerUser(@RequestBody UserRequestDto requestDto) {
        return userService.registerUser(requestDto);
    }

    @GetMapping("/kakao/callback")
    public ResponseEntity<KakaoUserResponseDto>  kakaoLogin(@RequestParam String code, HttpServletResponse response) throws JsonProcessingException {
        KakaoUserResponseDto kakaoUserResponseDto = kakaoUserService.kakaoLogin(code, response);
        return ResponseEntity.ok().body(kakaoUserResponseDto);
    }


}
