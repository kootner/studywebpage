package com.sparta.studywebpage.service;

import com.sparta.studywebpage.dto.CommentResponseDto;
import com.sparta.studywebpage.dto.ResponseDto;
import com.sparta.studywebpage.dto.StudyDetailDto;
import com.sparta.studywebpage.dto.StudyDetailRequestDto;
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

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class StudyDetailService {

    private final StudyRepository studyRepository;

    @Transactional(readOnly = true)
    public StudyDetailDto readStudyDetail(@PathVariable Long studyid) {

        StudyDetailDto studyDetailDto = new StudyDetailDto();
        Study study = studyRepository.findById(studyid).orElse(null);
        assert study != null;
        User user = study.getUser();
        List<CommentResponseDto> commentList = study.getCommentList().stream().map(CommentResponseDto::new).collect(Collectors.toList());

        studyDetailDto.setStudyTitle(study.getTitle());
        studyDetailDto.setStudyContent(study.getContent());
        studyDetailDto.setStudyAddress(study.getAddress());
        studyDetailDto.setUserNickname(user.getNickname());
        studyDetailDto.setUsername(user.getUsername());
        studyDetailDto.setCommentList(commentList);

        return studyDetailDto;
    }

    @Transactional
    public ResponseEntity<ResponseDto> updateStudyDetail(@PathVariable Long studyid, StudyDetailRequestDto requestDto) {

        Study study = studyRepository.findById(studyid).orElse(null);

        if (study == null)
            return new ResponseEntity<>(new ResponseDto(false, "수정 실패"), HttpStatus.BAD_REQUEST);

        if (requestDto.getStudyTitle() != null && requestDto.getStudyContent() != null && requestDto.getStudyAddress() != null) {

            study.setContent(requestDto.getStudyContent());
            study.setAddress(requestDto.getStudyAddress());
        } else
            return new ResponseEntity<>(new ResponseDto(false, "수정 실패"), HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(new ResponseDto(true, "수정 성공"), HttpStatus.OK);

    }

    public ResponseEntity<ResponseDto> deleteStudyDetail(@PathVariable Long studyid, UserDetailsImpl userDetails) {
        Study study = studyRepository.findById(studyid).orElseThrow(() ->
                new IllegalArgumentException("삭제 실패"));

        if (!study.getUser().getUsername().equals(userDetails.getUsername()))
            return new ResponseEntity<>(new ResponseDto(false, "삭제 실패"), HttpStatus.BAD_REQUEST);

        studyRepository.delete(study);
        return new ResponseEntity<>(new ResponseDto(true, "삭제 성공"), HttpStatus.OK);

    }
}
