package com.sparta.studywebpage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.studywebpage.dto.UserRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
@NoArgsConstructor
@Table(name="User_info")
public class User {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id //PK 설정
    private Long id;

    @Column(nullable = false, unique = true) //유니크 -> 중복허용
    private String username;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    public User(UserRequestDto userRequestDto){
        this.username = userRequestDto.getUsername();
        this.password = userRequestDto.getPassword();
        this.nickname = userRequestDto.getNickname();

    }

}
