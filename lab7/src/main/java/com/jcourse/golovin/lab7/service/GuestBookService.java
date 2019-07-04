package com.jcourse.golovin.lab7.service;

import com.jcourse.golovin.lab7.model.Record;

import java.util.List;

public interface GuestBookService {
    void addRecord(String message);

    List<Record> getRecords();
}