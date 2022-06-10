package com.sparta.studywebpage.model;

import com.sparta.studywebpage.dto.CommentsRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Comments {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name="User_Id")
    private User user;

    @ManyToOne
    @JoinColumn(name="Study_Id")
    private Study study;

    @Column(nullable = false)
    private String comment;

    public Comments (CommentsRequestDto commentsRequestDto){
        this.comment = commentsRequestDto.getComment();
    }

}
