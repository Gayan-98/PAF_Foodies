package com.senmash.postservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Entity
@AllArgsConstructor
@Data
@Table(name = "status")
public class Status {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int userId;

    private String path;
    @Column(columnDefinition = "timestamp without time zone")
    private Date timestamp;

    // No-args constructor to set the timestamp to the current time
    public Status() {
        this.timestamp = new Date(System.currentTimeMillis());
    }

}
