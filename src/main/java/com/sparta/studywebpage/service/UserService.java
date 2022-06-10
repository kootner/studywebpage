package com.sparta.studywebpage.service;

import com.sparta.studywebpage.dto.UserRequestDto;
import com.sparta.studywebpage.exception.CustomException;
import com.sparta.studywebpage.exception.ErrorCode;
import com.sparta.studywebpage.model.User;
import com.sparta.studywebpage.repository.UserRepository;
import com.sparta.studywebpage.validator.UserServiceValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserServiceValidator userServiceValidator;

    @Transactional
    public User registerUser( UserRequestDto requestDto){

        userServiceValidator.signupValidation(requestDto);
        User user = new User(requestDto);
        return userRepository.save(user);
    }
}
