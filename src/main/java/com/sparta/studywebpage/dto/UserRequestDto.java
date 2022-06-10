package com.sparta.studywebpage.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    String username;

    String nickname;

    String password;

    String password_confirm;
}
