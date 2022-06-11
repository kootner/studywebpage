package com.sparta.studywebpage.controller;

import com.sparta.studywebpage.dto.CategoryDto;
import com.sparta.studywebpage.dto.MainPageSearchDto;
import com.sparta.studywebpage.model.Study;
import com.sparta.studywebpage.security.UserDetailsImpl;
import com.sparta.studywebpage.service.MainPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class MainPageController {
    private final MainPageService mainPageService;

    @GetMapping("/")
    public List<MainPageSearchDto> getMainPage(){
        return mainPageService.getAllMainPageByCategory();

    }
    @PostMapping("/")
    public List<MainPageSearchDto> getMainPage(@RequestBody CategoryDto categoryDto){
        String category = categoryDto.getCategory();
        return mainPageService.getMainPageByCategory(category);
    }

}
