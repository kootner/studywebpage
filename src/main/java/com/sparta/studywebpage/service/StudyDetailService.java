package com.sparta.studywebpage.service;

import com.sparta.studywebpage.dto.*;
import com.sparta.studywebpage.model.Study;
import com.sparta.studywebpage.model.User;
import com.sparta.studywebpage.repository.StudyRepository;
import com.sparta.studywebpage.security.UserDetailsImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class StudyDetailService {

    private final StudyRepository studyRepository;

    @Transactional(readOnly = true)
    public StudyDetailDto readStudyDetail(@PathVariable Long studyid) {

        Study study = studyRepository.findById(studyid).orElse(null);
        assert study != null;
        User user = study.getUser();
        List<CommentLocalDateTimeDto> List = study.getCommentList().stream().map(CommentLocalDateTimeDto::new).collect(Collectors.toList());
        List<CommentResponseDto> commentList = new ArrayList<>();
        for (CommentLocalDateTimeDto commentLocalDateTimeDto : List) {
            CommentResponseDto commentResponseDto = new CommentResponseDto(commentLocalDateTimeDto);
            commentList.add(commentResponseDto);
        }

        return new StudyDetailDto(study, user, commentList);
    }


    @Transactional
    public ResponseEntity<ResponseDto> updateStudyDetail(@PathVariable Long studyid, StudyDetailRequestDto requestDto) {

        Study study = studyRepository.findById(studyid).orElse(null);

        if (study == null)
            return checkIdAction("수정");

        if (requestDto.getStudyTitle() != null && requestDto.getStudyContent() != null && requestDto.getStudyAddress() != null) {
            study.update(requestDto);
        } else {
            return checkIdAction("수정");
        }
        return successAction("수정");
    }


    public ResponseEntity<ResponseDto> deleteStudyDetail(@PathVariable Long studyid, UserDetailsImpl userDetails) {
        Study study = studyRepository.findById(studyid).orElseThrow(() ->
                new IllegalArgumentException("삭제 실패"));

        if (!study.getUser().getUsername().equals(userDetails.getUsername()))
            return checkIdAction("삭제");

        studyRepository.delete(study);
        return successAction("삭제");
    }


    public ResponseEntity<ResponseDto> checkIdAction(String action) {
        return new ResponseEntity<>(new ResponseDto(false, action + " 실패"), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ResponseDto> successAction(String action) {
        return new ResponseEntity<>(new ResponseDto(true, action + " 성공"), HttpStatus.OK);
    }

}
