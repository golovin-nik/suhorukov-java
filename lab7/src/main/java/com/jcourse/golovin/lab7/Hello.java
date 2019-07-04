package com.jcourse.golovin.lab7;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name = "SimpleServlet",
        urlPatterns = {"/simple"} )
//GET /simple HTTP/1.1
public class Hello extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getOutputStream().println("Hello");
    }
}

//GET, POST, PUT, DELETE ложится на принципы REST + CRUD