package com.example.commentservice.service;

import com.example.commentservice.dto.request.CreateCommentRequest;
import com.example.commentservice.dto.response.CreateCommentResponse;

import java.util.List;

public interface CommentService {
    void createComment(CreateCommentRequest request);

    List<CreateCommentResponse> getAllComments();

    CreateCommentResponse getCommentById(long commentId);

    void deleteById(long commentId);

    void updateById(CreateCommentRequest request, long commentId);
}
