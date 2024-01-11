package com.example.demopostservice.service.impl;

import com.example.demopostservice.dto.request.CreatePostRequest;
import com.example.demopostservice.dto.response.CreatePostResponse;
import com.example.demopostservice.dto.response.PostResponse;
import com.example.demopostservice.model.Post;
import com.example.demopostservice.repository.PostRepository;
import com.example.demopostservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public CreatePostResponse createPost(CreatePostRequest request) {

        Post post = new Post();
        post.setPhoto(request.getPhoto());
        post.setDescription(request.getDescription());
        post.setTag(request.getTag());
        post.setCreatedDate(LocalDateTime.now());

        postRepository.save(post);

        CreatePostResponse response = new CreatePostResponse();
        response.setId(post.getId());

        System.out.println("Post added successfully. Post ID: " + post.getId());

        return response;

    }

    @Override
    public List<PostResponse> getAllPosts() {
        System.out.println("Getting all posts");

        List<Post> posts = postRepository.findAll();
        List<PostResponse> createPostResponseList = new ArrayList<>();

        for (Post post : posts){
            PostResponse response = new PostResponse();

            response.setId(post.getId());
            response.setPhoto(post.getPhoto());
            response.setDescription(post.getDescription());
            response.setTag(post.getTag());
            response.setCreatedDate(post.getCreatedDate());

            createPostResponseList.add(response);
        }

        return createPostResponseList;
    }

    @Override
    public PostResponse getPostById(long postId) {
        System.out.println("Get post details by id : " + postId);

        Optional<Post> postOptional = postRepository.findById(postId);

        if (postOptional.isPresent()){
            Post post = postOptional.get();

            PostResponse response = new PostResponse();

            response.setId(post.getId());
            response.setPhoto(post.getPhoto());
            response.setDescription(post.getDescription());
            response.setTag(post.getTag());
            response.setCreatedDate(post.getCreatedDate());

            return response;
        }
        return null;
    }

    @Override
    public void deleteById(long postId) {
        System.out.println("post delete by id: " + postId);
        postRepository.deleteById(postId);
    }

    @Override
    public void updateById(CreatePostRequest request, long postId) {
        System.out.println("update by id : " + postId);

        Optional<Post> postOptional = postRepository.findById(postId);

        if (postOptional.isPresent()){
            Post post = postOptional.get();

            post.setPhoto(request.getPhoto());
            post.setDescription(request.getDescription());
            post.setTag(request.getTag());
            post.setCreatedDate(LocalDateTime.now());

            postRepository.save(post);
        }
    }
}
