package com.sparta.studywebpage.model;

import com.sparta.studywebpage.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comment extends Timestamped{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="study_id")
    private Study study;

    @Column(nullable = false)
    private String comment;

    public Comment(CommentRequestDto commentsRequestDto){
        this.comment = commentsRequestDto.getComment();
    }

}
