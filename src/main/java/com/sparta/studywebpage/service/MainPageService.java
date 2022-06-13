package com.sparta.studywebpage.service;


import com.sparta.studywebpage.dto.MainPageSearchDto;

import com.sparta.studywebpage.model.Study;
import com.sparta.studywebpage.repository.StudyRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MainPageService {

    private final StudyRepository studyRepository;



    @Transactional
    public List<MainPageSearchDto> getAllMainPageByCategory(){
        List<MainPageSearchDto> mainPageSearchDtos = new ArrayList<>();
        List<Study> studyList = studyRepository.findAll();
        for(Study study:studyList){
            MainPageSearchDto mainPageSearchDto = new MainPageSearchDto(study);
            mainPageSearchDtos.add(mainPageSearchDto);
        }
        return mainPageSearchDtos;
    }

    @Transactional
    public List<MainPageSearchDto> getMainPageByCategory(String category) {
        List<MainPageSearchDto> mainPageSearchDtos = new ArrayList<>();
        List<Study> studyList = studyRepository.findAllByCategory(category);
        for(Study study:studyList){
            String nickname = study.getUser().getNickname();
            String title = study.getTitle();
            category = study.getCategory();
            Long id = study.getId();
            MainPageSearchDto mainPageSearchDto = new MainPageSearchDto(study);
            mainPageSearchDto.setCategory(category);mainPageSearchDto.setCategory(category);
            mainPageSearchDto.setStudyId(id);
            mainPageSearchDto.setUserNickname(nickname);
            mainPageSearchDto.setStudyTitle(title);
            mainPageSearchDtos.add(mainPageSearchDto);
        }
        return mainPageSearchDtos;
    }
}
