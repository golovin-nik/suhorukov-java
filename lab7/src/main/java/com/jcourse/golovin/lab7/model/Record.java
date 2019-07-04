package com.jcourse.golovin.lab7.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Record {
    private Long id;
    private Timestamp postDate;
    private String postMessage;
}
