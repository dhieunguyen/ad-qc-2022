package com.example.pttk_dbclpm.controller;

import com.example.pttk_dbclpm.Response;
import com.example.pttk_dbclpm.dao.DatabaseConnection;
import com.example.pttk_dbclpm.dao.user.impl.UserDAOImpl;
import com.example.pttk_dbclpm.model.ThanhVien;
import com.example.pttk_dbclpm.utils.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserController extends HttpServlet {
    private UserDAOImpl userDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            userDAO = new UserDAOImpl();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getRequestURI();
        switch (action) {
            case "/user/check_login":{
                checkLogin(req,resp);
                break;
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getRequestURI();
        switch (action) {
            case "/user/get_users":{
                getUserList(req, resp);
                break;
            }
            case "/user/home":{
                goHomePage(req, resp);
                break;
            }
        }
    }
    private void goHomePage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("view/gdChinh.jsp").forward(request, response);
    }
    private void getUserList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<ThanhVien> thanhVienList = userDAO.getThanhVien();
        request.setAttribute("res", thanhVienList);
    }

    private void checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ThanhVien thanhVien = new ThanhVien(username,password);
        boolean isLoggedIn = userDAO.checkLogin(thanhVien);
        Response res;
        if(isLoggedIn){
            res = new Response(true,"Đăng nhập thành công",new ArrayList<>());
        }
        else {
            res = new Response(false,"Sai tài khoản mật khẩu",new ArrayList<>());
        }
        Utils.responseClient(res,response);
    }


}
