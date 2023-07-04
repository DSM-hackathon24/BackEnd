package com.example.backend.domain.comment.domain;

import com.example.backend.domain.board.domain.Board;
import com.example.backend.domain.user.domain.User;
import com.example.backend.global.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Comment extends BaseEntity {

    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "board_title", nullable = false)
    private Board board;

    @Builder
    public Comment(String comment){
        this.comment = comment;
    }

    public void update(String comment){
        this.comment = comment;
    }
}
