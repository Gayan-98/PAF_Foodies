package com.example.demopostservice.controller;

import com.example.demopostservice.dto.request.CreatePhotoRequest;
import com.example.demopostservice.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhotoController {

    @Autowired
    PhotoService photoService;

    @PostMapping("posts/{post-id}/photos")
    public void addPhoto(@RequestBody CreatePhotoRequest request, @PathVariable("post-id") long postId){
        photoService.create(postId, request);
    }
}
