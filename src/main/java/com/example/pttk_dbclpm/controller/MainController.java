package com.example.pttk_dbclpm.controller;

import com.example.pttk_dbclpm.Response;
import com.example.pttk_dbclpm.dao.film.PhimDAOImpl;
import com.example.pttk_dbclpm.dao.schedule.LichChieuPhimDAO;
import com.example.pttk_dbclpm.dao.schedule.LichChieuPhimDAOImpl;
import com.example.pttk_dbclpm.dao.user.impl.UserDAOImpl;
import com.example.pttk_dbclpm.model.LichChieuPhim;
import com.example.pttk_dbclpm.model.Phim;
import com.example.pttk_dbclpm.model.ThanhVien;
import com.example.pttk_dbclpm.utils.Utils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainController extends HttpServlet {
    private UserDAOImpl userDAO;
    private PhimDAOImpl phimDAO;
    private LichChieuPhimDAOImpl lichChieuPhimDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            userDAO = new UserDAOImpl();
            phimDAO = new PhimDAOImpl();
            lichChieuPhimDAO = new LichChieuPhimDAOImpl();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        System.out.println(action);
        switch (action) {
            case "/check_login": {
                checkLogin(req, resp);
                break;
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        System.out.println(action);
        switch (action) {
            case "/home": {
                goHomePage(req, resp);
                break;
            }
            case "/return-ticket": {
                goTicketReturnPage(req, resp);
                break;
            }
            case "/get-film":{
                getPhim(req,resp);
                break;
            }
            case "/get-film-schedule":{
                getLichChieuPhim(req,resp);
                break;
            }
            default: {
            }
        }
    }

    private void goHomePage(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        request.getRequestDispatcher("view/gdChinh.jsp").forward(request, response);
    }

    private void goTicketReturnPage(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        request.getRequestDispatcher("view/gdTraVe.jsp").forward(request, response);
    }

    private void getPhim(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        List<Phim> phimList = phimDAO.getPhim();
        Response res = new Response(true, "Thành công", phimList);
        Utils.responseClient(res, response);
    }
    private void getLichChieuPhim(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        String maPhim = request.getParameter("maPhim");
        Phim phim = new Phim(Integer.parseInt(maPhim));
        List<LichChieuPhim> lichChieuPhimList = lichChieuPhimDAO.getLichChieuPhim(phim);
        Response res = new Response(true, "Thành công", lichChieuPhimList);
        Utils.responseClient(res, response);
    }
    private void checkLogin(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ThanhVien thanhVien = new ThanhVien(username, password);
        boolean isLoggedIn = userDAO.checkLogin(thanhVien);
        Response res;
        if (isLoggedIn) {
            res = new Response(true, "Đăng nhập thành công", new ArrayList<>());
        } else {
            res = new Response(false, "Sai tài khoản mật khẩu", new ArrayList<>());
        }
        Utils.responseClient(res, response);
    }


}
