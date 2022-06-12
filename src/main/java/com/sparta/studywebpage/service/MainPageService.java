package com.sparta.studywebpage.service;


import com.sparta.studywebpage.dto.MainPageSearchDto;

import com.sparta.studywebpage.repository.StudyRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MainPageService {

    private final StudyRepository studyRepository;



    @Transactional
    public List<MainPageSearchDto> getAllMainPageByCategory(){
        return studyRepository.getAllStudies();
    }

    @Transactional
    public List<MainPageSearchDto> getMainPageByCategory(String category) {
        return studyRepository.getStudies(category);

    }
}
