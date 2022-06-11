package com.sparta.studywebpage.service;


import com.sparta.studywebpage.dto.MainPageSearchDto;
import com.sparta.studywebpage.model.Study;
import com.sparta.studywebpage.repository.StudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class MainPageService {

    private final StudyRepository studyRepository;



    @Transactional
    public  Page<MainPageSearchDto> getAllMainPageByCategory(int page, int size, String sortBy, boolean isAsc){
        Sort.Direction direction = isAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        return studyRepository.getAllStudies(pageable);
    }

    @Transactional
    public  Page<MainPageSearchDto> getMainPageByCategory(int page, int size, String sortBy, boolean isAsc, String category) {
        Sort.Direction direction = isAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        return studyRepository.getStudies(category,pageable);

    }
}
