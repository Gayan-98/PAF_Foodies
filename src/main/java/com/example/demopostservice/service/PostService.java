package com.example.demopostservice.service;

import com.example.demopostservice.dto.request.CreatePostRequest;
import com.example.demopostservice.dto.response.CreatePostResponse;
import com.example.demopostservice.dto.response.PostResponse;

import java.util.List;

public interface PostService {
    CreatePostResponse createPost(CreatePostRequest request);

    List<PostResponse> getAllPosts();

    PostResponse getPostById(long postId);

    void deleteById(long postId);

    void updateById(CreatePostRequest request, long postId);

}

