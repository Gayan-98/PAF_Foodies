package com.senmash.postservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusResponse {

    private int id;
    private String path;
    private Date timestamp;

    private User user;


}
