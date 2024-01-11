package com.example.demopostservice.controller;


import com.example.demopostservice.dto.request.CreatePostRequest;
import com.example.demopostservice.dto.response.CreatePostResponse;
import com.example.demopostservice.dto.response.PostResponse;
import com.example.demopostservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/posts")
    public CreatePostResponse addPost(@RequestBody CreatePostRequest request){
       return postService.createPost(request);
    }

    @GetMapping("/posts")
    public List<PostResponse> getAll(){
        return postService.getAllPosts();
    }

    @GetMapping("/posts/{post-id}")
    public PostResponse getPostId(@PathVariable ("post-id") long postId){
        return postService.getPostById(postId);
    }

    @DeleteMapping("/posts/{post-id}")
    public void deletePost(@PathVariable ("post-id") long postId){
        postService.deleteById(postId);
    }

    @PutMapping("/posts/{post-id}")
    public void updatePost(@RequestBody CreatePostRequest request, @PathVariable ("post-id") long postId){
        postService.updateById(request,postId);
    }

}
