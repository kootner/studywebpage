package com.sparta.studywebpage.service;

import com.sparta.studywebpage.dto.StudyDetailDto;
import com.sparta.studywebpage.model.Comment;
import com.sparta.studywebpage.model.Study;
import com.sparta.studywebpage.model.User;
import com.sparta.studywebpage.repository.StudyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StudyDetailService {

    private final StudyRepository studyRepository;

    public StudyDetailDto readStudyDetail (@PathVariable Long studyid) {

        StudyDetailDto studyDetailDto = new StudyDetailDto();
        Study study = studyRepository.getReferenceById(studyid);
        User user = study.getUser();
        List<Comment> commentList = study.getCommentList();

        studyDetailDto.setStudyTitle(study.getTitle());
        studyDetailDto.setStudyContent(study.getContent());
        studyDetailDto.setStudyAddress(study.getAddress());
        studyDetailDto.setUserNickname(user.getNickname());
        studyDetailDto.setUsername(user.getUsername());
        studyDetailDto.setCommentList(commentList);

        return studyDetailDto;

    }


}
