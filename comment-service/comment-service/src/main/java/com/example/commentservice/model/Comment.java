package com.example.commentservice.model;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String name;
    private String comment;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    // Constructors, getters, and setters can be added if necessary
}