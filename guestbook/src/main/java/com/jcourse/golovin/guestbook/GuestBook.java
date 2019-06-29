package com.jcourse.golovin.guestbook;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class GuestBook {

    private static Connection connection;

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.h2.Driver");

        try {
            connection = DriverManager
                    .getConnection("jdbc:h2:mem:mydatabase", "user1", "password1");
            Statement statement = connection.createStatement();
            statement.execute("create table posts(id identity, post_date timestamp, post_message varchar(255))");

            PreparedStatement preparedStatement = connection
                    .prepareStatement(
                            "insert into posts(post_date, post_message) " +
                            "values (?, ?)");
            preparedStatement.setTimestamp(1, Timestamp.from(Instant.now()));
            preparedStatement.setString(2, "Hello, World!");
            preparedStatement.execute();

            statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT * FROM posts");
            List<Record> records = new ArrayList<>();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                Timestamp postDate = resultSet.getTimestamp("post_date");
                String postMessage = resultSet.getString("post_message");
                Record record = new Record(id, postDate, postMessage);
                records.add(record);
            }
            System.out.println("records = " + records);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
