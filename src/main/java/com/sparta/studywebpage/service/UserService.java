package com.sparta.studywebpage.service;

import com.sparta.studywebpage.dto.UserRequestDto;
import com.sparta.studywebpage.model.User;
import com.sparta.studywebpage.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User registerUser(@RequestBody UserRequestDto requestDto){

        String email = requestDto.getEmail();
        String nickname = requestDto.getNickname();
        String password = requestDto.getPassword();;
        String password_confirm = requestDto.getPassword_confirm();

        if(userRepository.existsByEmail(email)){
            throw new
        }

    }
}
