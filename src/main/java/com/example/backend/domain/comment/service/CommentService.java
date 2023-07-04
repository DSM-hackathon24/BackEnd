package com.example.backend.domain.comment.service;

import com.example.backend.domain.comment.domain.Comment;
import com.example.backend.domain.comment.domain.repository.CommentRepository;
import com.example.backend.domain.comment.presentation.dto.request.CommentAddRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public void addComment(CommentAddRequest request){
        commentRepository.save(
                Comment.builder()
                        .comment(request.getComment())
                        .build());
    }
}
