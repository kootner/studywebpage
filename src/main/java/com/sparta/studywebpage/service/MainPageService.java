package com.sparta.studywebpage.service;


import com.sparta.studywebpage.dto.MainPageSearchDto;

import com.sparta.studywebpage.model.Study;
import com.sparta.studywebpage.repository.StudyRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MainPageService {

    private final StudyRepository studyRepository;


    @Transactional(readOnly = true)
    public List<MainPageSearchDto> getAllMainPageByCategory(){
        List<MainPageSearchDto> mainPageSearchDtos = new ArrayList<>();
        List<Study> studyList = studyRepository.findAll();
        for(Study study:studyList){
            MainPageSearchDto mainPageSearchDto = new MainPageSearchDto(study);
            mainPageSearchDtos.add(mainPageSearchDto);
        }
        return mainPageSearchDtos;
    }

    @Transactional(readOnly = true)
    public List<MainPageSearchDto> getMainPageByCategory(String category) {
        List<MainPageSearchDto> mainPageSearchDtos = new ArrayList<>();
        List<Study> studyList = studyRepository.findAllByCategory(category);
        for(Study study:studyList){
            MainPageSearchDto mainPageSearchDto = new MainPageSearchDto(study);
            mainPageSearchDtos.add(mainPageSearchDto);
        }
        return mainPageSearchDtos;
    }
}
