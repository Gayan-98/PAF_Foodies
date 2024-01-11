package com.example.demopostservice.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostResponse {
    private Long id;
    private String photo;
    private String description;
    private String tag;
    private LocalDateTime createdDate;
}
