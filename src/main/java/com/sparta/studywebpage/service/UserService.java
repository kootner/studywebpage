package com.sparta.studywebpage.service;


import com.sparta.studywebpage.dto.UserRequestDto;
import com.sparta.studywebpage.model.User;

import com.sparta.studywebpage.repository.UserRepository;
import com.sparta.studywebpage.validator.UserServiceValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
<<<<<<< HEAD
=======

>>>>>>> origin/JungHoon
    private final PasswordEncoder passwordEncoder;
    private final UserServiceValidator userServiceValidator;

    @Transactional
    public void registerUser(UserRequestDto requestDto){

        userServiceValidator.signupValidation(requestDto);
        requestDto.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        User user = new User(requestDto);
        userRepository.save(user);
    }


}
