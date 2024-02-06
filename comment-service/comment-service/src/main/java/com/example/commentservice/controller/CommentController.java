package com.example.commentservice.controller;

import com.example.commentservice.dto.request.CreateCommentRequest;
import com.example.commentservice.dto.response.CreateCommentResponse;
import com.example.commentservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/comments")
    public void addComment(@RequestBody CreateCommentRequest request) {
        commentService.createComment(request);
    }

    @GetMapping("/comments")
    public List<CreateCommentResponse> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/comments/{comment-id}")
    public CreateCommentResponse getCommentById(@PathVariable("comment-id") long commentId) {
        return commentService.getCommentById(commentId);
    }

    @DeleteMapping("/comments/{comment-id}")
    public void deleteComment(@PathVariable("comment-id") long commentId) {
        commentService.deleteById(commentId);
    }

    @PutMapping("/comments/{comment-id}")
    public void updateComment(@RequestBody CreateCommentRequest request, @PathVariable("comment-id") long commentId) {
        commentService.updateById(request, commentId);
    }
}
