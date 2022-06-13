package com.sparta.studywebpage.model;


import lombok.*;
import lombok.NoArgsConstructor;

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

    public Comment(String comment, User user, Study study){
        this.comment = comment;
        this.user = user;
        this.study = study;
    }

    public void update(String comment) {
        this.comment = comment;
    }
}
