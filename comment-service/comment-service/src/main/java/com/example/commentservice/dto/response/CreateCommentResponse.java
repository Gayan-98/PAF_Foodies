package com.example.commentservice.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateCommentResponse {
    private Long userId;
    private String name;
    private String comment;

    public void setId(Long id) {
    }

    public void setCreatedDate(LocalDateTime createdDate) {
    }
}
