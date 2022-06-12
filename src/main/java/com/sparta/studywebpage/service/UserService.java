package com.sparta.studywebpage.service;


import com.sparta.studywebpage.dto.ResponseDto;
import com.sparta.studywebpage.dto.UserRequestDto;
import com.sparta.studywebpage.exception.CustomException;
import com.sparta.studywebpage.model.User;

import com.sparta.studywebpage.repository.UserRepository;
import com.sparta.studywebpage.validator.UserServiceValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserServiceValidator userServiceValidator;

    @Transactional
    public ResponseEntity<ResponseDto> registerUser(UserRequestDto requestDto){
        try {
            userServiceValidator.signupValidation(requestDto);
        } catch (CustomException e){
            return new ResponseEntity<>(new ResponseDto(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }

        requestDto.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        User user = new User(requestDto);
        userRepository.save(user);
        return new ResponseEntity<>(new ResponseDto(true,"회원가입 성공"), HttpStatus.OK);
    }


}
