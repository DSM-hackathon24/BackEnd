package com.example.backend.domain.comment.presentation;

import com.example.backend.domain.comment.domain.Comment;
import com.example.backend.domain.comment.presentation.dto.request.CommentAddRequest;
import com.example.backend.domain.comment.service.CreateCommentService;
import com.example.backend.domain.comment.service.DeleteCommentService;
import com.example.backend.domain.comment.service.ListCommentService;
import com.example.backend.domain.comment.service.ModifyCommentService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/comment")
@RestController
public class CommentController {

    private final CreateCommentService createCommentService;
    private final DeleteCommentService deleteCommentService;
    private final ListCommentService listCommentService;
    private final ModifyCommentService modifyCommentService;

    @Operation(summary = "댓글 생성")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createComment(@RequestBody CommentAddRequest request, Long boardId){
        createCommentService.addComment(request, boardId);
    }

    @Operation(summary = "댓글 삭제")
    @DeleteMapping("/delete")
    public void deleteComment(@PathVariable Long boardId, @PathVariable Long commentId){
        deleteCommentService.deleteComment(boardId, commentId);
    }

}
