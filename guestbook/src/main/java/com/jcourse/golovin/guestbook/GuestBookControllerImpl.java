package com.jcourse.golovin.guestbook;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class GuestBookControllerImpl implements GuestBookController{
    public void addRecord(String message) {

    }

    public List<Record> getRecords() {
        Record record = new Record(1L,
                Timestamp.from(Instant.now()),
                "message");
        return Arrays.asList(
                record);
    }
}
