package com.sparta.studywebpage.service;

import com.sparta.studywebpage.dto.StudyRequestDto;
import com.sparta.studywebpage.model.Study;
import com.sparta.studywebpage.repository.StudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudyService {

    private final StudyRepository studyRepository;
    public void createStudy(StudyRequestDto studyRequestDto) {
        Study study = new Study(studyRequestDto);
        studyRepository.save(study);
    }

    public Study readStudy(Long studyId) {
       Study study = studyRepository.findById(studyId)
               .orElseThrow(() -> new NullPointerException("해당 아이디가 존재하지 않습니다."));

        return study;
    }

    public void updateStudy(Long studyId) {

    }
}
