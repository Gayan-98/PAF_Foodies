package com.example.commentservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCommentRequest {

    private Long userId;
    private String name;
    private String comment;
}
