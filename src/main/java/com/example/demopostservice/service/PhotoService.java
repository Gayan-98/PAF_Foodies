package com.example.demopostservice.service;

import com.example.demopostservice.dto.request.CreatePhotoRequest;

public interface PhotoService {
    void create(long postId, CreatePhotoRequest request);
}
