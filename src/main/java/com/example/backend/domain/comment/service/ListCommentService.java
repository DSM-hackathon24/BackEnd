package com.example.backend.domain.comment.service;

import com.example.backend.domain.board.domain.Board;
import com.example.backend.domain.board.presentation.dto.response.QueryBoardListResponse;
import com.example.backend.domain.comment.domain.Comment;
import com.example.backend.domain.comment.domain.repository.CommentRepository;
import com.example.backend.domain.comment.facade.CommentFacade;
import com.example.backend.domain.comment.presentation.dto.response.CommentListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListCommentService {

    private final CommentFacade commentFacade;

    @Transactional(readOnly = true)
    public List<CommentListResponse> execute() {

        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        List<Comment> comments = commentFacade.getCommentAllById(sort);

        return comments.stream()
                .map(comment -> CommentListResponse.builder()
                        .commentId(comment.getId())
                        .w(board.getTitle())
                        .date(board.getCreatedAt())
                        .build())
                .toList();
    }
}
