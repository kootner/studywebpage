package com.sparta.studywebpage.controller;

import com.sparta.studywebpage.dto.CategoryDto;
import com.sparta.studywebpage.dto.MainPageSearchDto;
import com.sparta.studywebpage.model.Study;
import com.sparta.studywebpage.security.UserDetailsImpl;
import com.sparta.studywebpage.service.MainPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class MainPageController {
    private final MainPageService mainPageService;

    @GetMapping("/")
    public Page<MainPageSearchDto> getMainPage(@RequestParam("page") int page,
                                               @RequestParam("size") int size,
                                               @RequestParam("sortBy") String sortBy,
                                               @RequestParam("isAsc") boolean isAsc,
                                               @RequestBody CategoryDto categoryDto
                                   ){
        String category = categoryDto.getCategory();
        page = page - 1;
        if(category==null){
            return mainPageService.getAllMainPageByCategory(page,size,sortBy,isAsc);
        }
        return mainPageService.getMainPageByCategory(page,size,sortBy,isAsc,category);
    }

}
