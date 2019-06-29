package com.jcourse.golovin.guestbook;

import java.util.List;

public interface GuestBookController{
    void addRecord(String message);

    List<Record> getRecords();
}