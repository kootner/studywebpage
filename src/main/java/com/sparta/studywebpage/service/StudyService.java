package com.sparta.studywebpage.service;

import com.sparta.studywebpage.dto.ResponseDto;
import com.sparta.studywebpage.dto.StudyRequestDto;
import com.sparta.studywebpage.exception.CustomException;
import com.sparta.studywebpage.exception.ErrorCode;
import com.sparta.studywebpage.model.Study;
import com.sparta.studywebpage.model.User;
import com.sparta.studywebpage.repository.StudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class StudyService {

    private final StudyRepository studyRepository;

    @Transactional
    public ResponseEntity<ResponseDto> createStudy(StudyRequestDto studyRequestDto, User user) {
        Study study = Study.builder()
                .category(studyRequestDto.getCategory())
                .title(studyRequestDto.getStudyTitle())
                .address(studyRequestDto.getStudyAddress())
                .content(studyRequestDto.getStudyContent())
                .user(user)
                .build();
        try{
            checkStudy(study);
        } catch (CustomException e) {
            return new ResponseEntity<>(new ResponseDto(false,e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        studyRepository.save(study);
        return new ResponseEntity<>(new ResponseDto(true,"작성 성공"), HttpStatus.OK);

    }


    public void checkStudy(Study study){
        if(study.getTitle() == null){
            throw new CustomException(ErrorCode.NULL_TITLE);
        }
        if(study.getAddress() == null){
            throw new CustomException(ErrorCode.NULL_ADDRESS);
        }
        if(study.getContent() == null) {
            throw new CustomException(ErrorCode.NULL_CONTENT);
        }
    }
}
