package com.sparta.studywebpage.service;

import com.sparta.studywebpage.dto.StudyRequestDto;
import com.sparta.studywebpage.model.Study;
import com.sparta.studywebpage.model.User;
import com.sparta.studywebpage.repository.StudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class StudyService {

    private final StudyRepository studyRepository;

    @Transactional
    public void createStudy(StudyRequestDto studyRequestDto, User user) {

        Study study = new Study(studyRequestDto,user);
        studyRepository.save(study);
    }
}
