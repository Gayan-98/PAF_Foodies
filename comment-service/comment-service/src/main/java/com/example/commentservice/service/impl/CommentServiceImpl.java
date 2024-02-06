package com.example.commentservice.service.impl;

import com.example.commentservice.dto.request.CreateCommentRequest;
import com.example.commentservice.dto.response.CreateCommentResponse;
import com.example.commentservice.model.Comment;
import com.example.commentservice.repository.CommentRepository;
import com.example.commentservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void createComment(CreateCommentRequest request) {
        Comment comment = new Comment();
        comment.setUserId(request.getUserId());
        comment.setName(request.getName());
        comment.setComment(request.getComment());
        comment.setCreatedDate(LocalDateTime.now());

        commentRepository.save(comment);

        System.out.println("Comment added successfully. Comment ID: " + comment.getId());
    }

    @Override
    public List<CreateCommentResponse> getAllComments() {
        System.out.println("Getting all comments");

        List<Comment> comments = commentRepository.findAll();
        List<CreateCommentResponse> commentResponseList = new ArrayList<>();

        for (Comment comment : comments) {
            CreateCommentResponse response = new CreateCommentResponse();
            response.setId(comment.getId());
            response.setUserId(comment.getUserId());
            response.setName(comment.getName());
            response.setComment(comment.getComment());
            response.setCreatedDate(comment.getCreatedDate());
            commentResponseList.add(response);
        }

        return commentResponseList;
    }

    @Override
    public CreateCommentResponse getCommentById(long commentId) {
        System.out.println("Get comment details by id : " + commentId);

        Optional<Comment> commentOptional = commentRepository.findById(commentId);

        if (commentOptional.isPresent()) {
            Comment comment = commentOptional.get();
            CreateCommentResponse response = new CreateCommentResponse();
            response.setId(comment.getId());
            response.setUserId(comment.getUserId());
            response.setName(comment.getName());
            response.setComment(comment.getComment());
            response.setCreatedDate(comment.getCreatedDate());
            return response;
        }
        return null;
    }

    @Override
    public void deleteById(long commentId) {
        System.out.println("Comment delete by id: " + commentId);
        commentRepository.deleteById(commentId);
    }

    @Override
    public void updateById(CreateCommentRequest request, long commentId) {
        System.out.println("Update comment by id : " + commentId);

        Optional<Comment> commentOptional = commentRepository.findById(commentId);

        if (commentOptional.isPresent()) {
            Comment comment = commentOptional.get();
            comment.setUserId(request.getUserId());
            comment.setName(request.getName());
            comment.setComment(request.getComment());
            comment.setCreatedDate(LocalDateTime.now());
            commentRepository.save(comment);
        }
    }
}
