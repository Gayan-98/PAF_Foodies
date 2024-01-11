package com.example.demopostservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CreatePostRequest {
    private Long id;
    private  String photo;
    private String description;
    private String tag;
    private LocalDateTime createdDate;
}
