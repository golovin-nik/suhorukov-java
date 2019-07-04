package com.jcourse.golovin.lab7.controller;

import com.jcourse.golovin.lab7.model.Record;
import com.jcourse.golovin.lab7.service.GuestBookService;
import com.jcourse.golovin.lab7.service.GuestBookServiceImpl;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "GuestBookServlet",
        urlPatterns = {"/guestbook"})
//POST /guestbook?message=Hello
public class GuestBookServlet extends HttpServlet {

    private GuestBookService guestBookService;
    @Resource(name = "jdbc/testDS")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        try {
            this.guestBookService = new GuestBookServiceImpl(dataSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("doGet");
        List<Record> records = guestBookService.getRecords();
        req.setAttribute("records", records);
        req.getRequestDispatcher("/WEB-INF/guestbook.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String message = req.getParameter("message");
        System.out.println("doPost message: " + message);
        if (message != null && !message.isEmpty()) {
            guestBookService.addRecord(message);
        }
        doGet(req, resp);
    }
}
