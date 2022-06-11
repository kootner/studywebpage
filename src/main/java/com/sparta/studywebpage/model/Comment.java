package com.sparta.studywebpage.model;

import com.sparta.studywebpage.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Comment extends Timestamped{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="User_Id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Study_Id")
    private Study study;

    @Column(nullable = false)
    private String comment;

    public Comment(CommentRequestDto commentsRequestDto){
        this.comment = commentsRequestDto.getComment();
    }

}