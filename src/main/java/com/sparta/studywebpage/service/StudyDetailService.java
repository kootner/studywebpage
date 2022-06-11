package com.sparta.studywebpage.service;

import com.sparta.studywebpage.dto.StudyDetailDto;
import com.sparta.studywebpage.repository.StudyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
@Service
public class StudyDetailService {

    private final StudyRepository studyRepository;

    public StudyDetailDto readStudyDetail (@PathVariable Long studyid) {

        StudyDetailDto studyDetailDto = new StudyDetailDto()



    }


}
