package com.sparta.studywebpage.service;


import com.sparta.studywebpage.dto.UserRequestDto;
import com.sparta.studywebpage.model.User;

import com.sparta.studywebpage.repository.UserRepository;
import com.sparta.studywebpage.validator.UserServiceValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;


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
