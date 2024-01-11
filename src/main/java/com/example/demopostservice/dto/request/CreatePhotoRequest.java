package com.example.demopostservice.dto.request;

import lombok.Data;

@Data
public class CreatePhotoRequest {
    private Long id;
    private String photo;
}
