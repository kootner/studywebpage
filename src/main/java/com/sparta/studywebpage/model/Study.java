package com.sparta.studywebpage.model;

import com.sparta.studywebpage.dto.StudyRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Study {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name="User_Id")
    private User user;



    public Study(StudyRequestDto studyRequestDto) {
       this.title = studyRequestDto.getStudyTitle();
       this.content = studyRequestDto.getStudyContent();
       this.address = studyRequestDto.getStudyAddress();
        this.user = studyRequestDto.getUser();
    }
}
