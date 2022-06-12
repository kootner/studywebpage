package com.sparta.studywebpage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sparta.studywebpage.dto.StudyRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Study {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(nullable = false)
    private String category;

    @OneToMany(mappedBy = "study", cascade = CascadeType.REMOVE)
    private List<Comment> commentList;



    public Study(StudyRequestDto studyRequestDto,User user) {
       this.title = studyRequestDto.getStudyTitle();
       this.content = studyRequestDto.getStudyContent();
       this.address = studyRequestDto.getStudyAddress();
       this.user = user;
       this.category = studyRequestDto.getCategory();
    }

    public void update(StudyRequestDto studyRequestDto) {
        this.title = studyRequestDto.getStudyTitle();
        this.content = studyRequestDto.getStudyContent();
        this.address = studyRequestDto.getStudyAddress();
    }
}
