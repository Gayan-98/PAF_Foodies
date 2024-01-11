package com.example.demopostservice.service.impl;

import com.example.demopostservice.dto.request.CreatePhotoRequest;
import com.example.demopostservice.model.Photo;
import com.example.demopostservice.model.Post;
import com.example.demopostservice.repository.PhotoRepository;
import com.example.demopostservice.repository.PostRepository;
import com.example.demopostservice.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    PhotoRepository photoRepository;

    @Autowired
    PostRepository postRepository;


    @Override
    public void create(long postId, CreatePhotoRequest request) {

        Optional<Post> postOptional = postRepository.findById(postId);

        if (postOptional.isPresent()){
            Post post = postOptional.get();

            Photo photo = new Photo();
            photo.setPhoto(request.getPhoto());

            photo.setPost(post);

            photoRepository.save(photo);

        }
    }
}
