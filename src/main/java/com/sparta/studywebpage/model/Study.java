package com.sparta.studywebpage.model;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="User_Id")
    private User user;

    @Column(nullable = false)
    private String category;

    @OneToMany(mappedBy = "study", cascade = CascadeType.REMOVE)
    private List<Comment> commentList;



    public Study(StudyRequestDto studyRequestDto) {
       this.title = studyRequestDto.getStudyTitle();
       this.content = studyRequestDto.getStudyContent();
       this.address = studyRequestDto.getStudyAddress();
        this.user = studyRequestDto.getUser();
        this.category = studyRequestDto.getCategory();
    }

    public void update(StudyRequestDto studyRequestDto) {
        this.title = studyRequestDto.getStudyTitle();
        this.content = studyRequestDto.getStudyContent();
        this.address = studyRequestDto.getStudyAddress();
    }
}
