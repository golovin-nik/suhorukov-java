package com.jcourse.golovin.lab7.service;

import com.jcourse.golovin.lab7.model.Record;

import javax.sql.DataSource;
import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class GuestBookServiceImpl implements GuestBookService {


    public static final String DATASOURCE_URL = "jdbc:h2:mem:mydatabase";
    public static final String DATASOURCE_USER = "user1";
    public static final String DATASOURCE_PASSWORD = "password1";

    public static final String CREATE_TABLE_POSTS_SCRIPT =
            "create table posts(" +
                    "id identity, " +
                    "post_date timestamp, " +
                    "post_message varchar(255))";
    public static final String INSERT_INTO_POSTS_SCRIPT =
            "insert into posts(post_date, post_message) " +
                    "values (?, ?)";
    public static final String SELECT_FROM_POSTS_SCRIPT =
            "SELECT * " +
                    "FROM posts";

    private final DataSource dataSource;

    public GuestBookServiceImpl(DataSource dataSource) throws SQLException {
        this.dataSource = dataSource;
        initDb();
    }

    private void initDb() throws SQLException {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(CREATE_TABLE_POSTS_SCRIPT);
        }
    }

    public void addRecord(String message) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(INSERT_INTO_POSTS_SCRIPT)) {
            preparedStatement.setTimestamp(1, Timestamp.from(Instant.now()));
            preparedStatement.setString(2, message);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Record> getRecords() {
        List<Record> records = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement
                     .executeQuery(SELECT_FROM_POSTS_SCRIPT)) {
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                Timestamp postDate = resultSet.getTimestamp("post_date");
                String postMessage = resultSet.getString("post_message");
                Record record = new Record(id, postDate, postMessage);
                records.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }
}
