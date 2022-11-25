package com.example.pttk_dbclpm.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class BaseController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);
        switch (action) {
            case "/home":
                goHomePage(request, response);
                break;
            default:
                goLoginPage(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void goHomePage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        System.out.println("keke");
//        request.getRequestDispatcher("view/gdChinh.jsp").forward(request, response);
    }

    private void goLoginPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("view/login.jsp").forward(request, response);
    }
}
