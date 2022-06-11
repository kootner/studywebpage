package com.sparta.studywebpage.dto;


import lombok.Getter;

@Getter
public class ResponseDto {
    private boolean ok;
    private String message;

    public ResponseDto(boolean ok, String message) {
        this.ok =  ok;
        this.message = message;
    }
}
