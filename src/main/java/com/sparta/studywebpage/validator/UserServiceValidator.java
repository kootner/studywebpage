package com.sparta.studywebpage.validator;

import com.sparta.studywebpage.dto.UserRequestDto;
import com.sparta.studywebpage.exception.CustomException;
import com.sparta.studywebpage.exception.ErrorCode;
import com.sparta.studywebpage.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



@RequiredArgsConstructor
public class UserServiceValidator {
    private final UserRepository userRepository;

    public void signupValidation(UserRequestDto requestDto){
        String email = requestDto.getEmail();
        String nickname = requestDto.getNickname();
        String password = requestDto.getPassword();;
        String password_confirm = requestDto.getPassword_confirm();
        String regx = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regx);

        Matcher matcher = pattern.matcher(email);


        if(userRepository.existsByEmail(email)){
            throw new CustomException(ErrorCode.EXIST_EMAIL);
        }
        if(userRepository.existsByNickname(nickname)){
            throw new CustomException(ErrorCode.EXIST_NICKNAME);
        }if(!matcher.matches()){
            throw new CustomException(ErrorCode.WRONG_FORMAT_EMAIL);
        }
        if(!requestDto.getPassword().matches("^[a-z0-9-_]{4,12}$")){
            throw new CustomException(ErrorCode.WRONG_FORMAT_PASSWORD);
        }if(password!=password_confirm){
            throw new CustomException(ErrorCode.PASSWORD_NOT_CONFIRM);
        }

    }

}
