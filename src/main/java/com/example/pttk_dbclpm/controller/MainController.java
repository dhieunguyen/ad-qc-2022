package com.example.pttk_dbclpm.controller;

import com.example.pttk_dbclpm.Response;
import com.example.pttk_dbclpm.dao.customer.KhachHangDAO;
import com.example.pttk_dbclpm.dao.customer.KhachHangDAOImpl;
import com.example.pttk_dbclpm.dao.film.PhimDAO;
import com.example.pttk_dbclpm.dao.film.PhimDAOImpl;
import com.example.pttk_dbclpm.dao.fine.KhungPhatDAO;
import com.example.pttk_dbclpm.dao.fine.KhungPhatDAOImpl;
import com.example.pttk_dbclpm.dao.fine_bill.HoaDonPhatDAO;
import com.example.pttk_dbclpm.dao.fine_bill.HoaDonPhatDAOImpl;
import com.example.pttk_dbclpm.dao.room.PhongChieuDAO;
import com.example.pttk_dbclpm.dao.room.PhongChieuDAOImpl;
import com.example.pttk_dbclpm.dao.schedule.LichChieuPhimDAO;
import com.example.pttk_dbclpm.dao.schedule.LichChieuPhimDAOImpl;
import com.example.pttk_dbclpm.dao.ticket.VeDAO;
import com.example.pttk_dbclpm.dao.ticket.VeDAOImpl;
import com.example.pttk_dbclpm.dao.user.ThanhVienDAO;
import com.example.pttk_dbclpm.dao.user.ThanhVienDAOImpl;
import com.example.pttk_dbclpm.model.*;
import com.example.pttk_dbclpm.utils.Utils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainController extends HttpServlet {
    private ThanhVienDAO userDAO;
    private PhimDAO phimDAO;
    private LichChieuPhimDAO lichChieuPhimDAO;
    private VeDAO veDAO;
    private PhongChieuDAO phongChieuDAO;
    private KhungPhatDAO khungPhatDAO;
    private KhachHangDAO khachHangDAO;
    private HoaDonPhatDAO hoaDonPhatDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            userDAO = new ThanhVienDAOImpl();
            phimDAO = new PhimDAOImpl();
            lichChieuPhimDAO = new LichChieuPhimDAOImpl();
            phongChieuDAO = new PhongChieuDAOImpl();
            veDAO = new VeDAOImpl();
            khungPhatDAO = new KhungPhatDAOImpl();
            khachHangDAO = new KhachHangDAOImpl();
            hoaDonPhatDAO = new HoaDonPhatDAOImpl();
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
            case "/create-fine-bill": {
                createFineBill(req, resp);
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
            case "/get-film": {
                getPhim(req, resp);
                break;
            }
            case "/get-film-schedule-by-film": {
                getLichChieuPhimByPhim(req, resp);
                break;
            }
            case "/get-film-schedule-by-room": {
                getLichChieuPhimByRoom(req, resp);
                break;
            }
            case "/get-tickets": {
                getVe(req, resp);
                break;
            }
            case "/get-rooms": {
                getPhong(req, resp);
                break;
            }
            case "/fine-bill": {
                goFineBill(req, resp);
                break;
            }
            case "/fine-range": {
                getFineRange(req, resp);
                break;
            }
            case "/get-customer": {
                getKhachHang(req, resp);
                break;
            }
            default: {
            }
        }
    }


    private void goFineBill(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        request.getRequestDispatcher("view/gdHoaDonPhat.jsp").forward(request, response);
    }

    private void goHomePage(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        request.getRequestDispatcher("view/gdChinh.jsp").forward(request, response);
    }

    private void goTicketReturnPage(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        request.getRequestDispatcher("view/gdTraVe.jsp").forward(request, response);
    }

    private void getFineRange(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        String time = request.getParameter("time");
        KhungPhat khungPhat = khungPhatDAO.getKhungPhat(Integer.parseInt(time));
        Response res;
        if (khungPhat == null) {
            res = new Response(false, "???? x???y ra l???i", khungPhat);
        } else if (Integer.parseInt(time) < 0) {
            res = new Response(false, "Phim n??y ???? ???????c chi???u, kh??ng th??? ho??n v??", khungPhat);
        } else {
            res = new Response(true, "Th??nh c??ng", khungPhat);
        }
        Utils.responseClient(res, response);
    }

    private void getVe(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        String seats = request.getParameter("seats");
        String scheduleId = request.getParameter("scheduleId");
        String notSoldTicketsStr = "";
        Response res = null;
        LichChieuPhim lichChieuPhim = new LichChieuPhim(Integer.parseInt(scheduleId));
        String[] seatsArr = seats.split(",");
        List<Ve> seatList = new ArrayList<>();
        for (int i = 0; i < seatsArr.length; i++) {
            seatList.add(new Ve(seatsArr[i]));
        }
        List<Ve> veList = veDAO.getVe(lichChieuPhim, seatList);
        List<Ve> notSoldTickets = veList.stream()
                .filter(v -> v.getTrangThaiVe() == Ve.CHUA_BAN).collect(Collectors.toList());
        if(veList.size()==0){
            res = new Response(false, "Kh??ng t???n t???i v?? n??y", null);
        }
        else if (notSoldTickets.size() > 0) {
            for (int i = 0; i < notSoldTickets.size(); i++) {
                notSoldTicketsStr += notSoldTickets.get(i).getSoGhe() + (i != notSoldTickets.size() - 1 ? "," : "");
            }
            res = new Response(false, "V?? " + notSoldTicketsStr + " ch??a ???????c b??n", new ArrayList());
        }
        else {
            res = new Response(true, "Th??nh c??ng", veList);
        }
        Utils.responseClient(res, response);
    }

    private void getPhim(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        List<Phim> phimList = phimDAO.getPhim();
        Response res = null;
        if (phimList == null) {
            res = new Response(false, "???? x???y ra l???i", phimList);
        } else
            res = new Response(true, "Th??nh c??ng", phimList);
        Utils.responseClient(res, response);
    }

    private void getKhachHang(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        String maVach = request.getParameter("barcode");
        TheThanhVien ttv = new TheThanhVien(maVach);
        KhachHang khachHang = khachHangDAO.getKhachHang(ttv);
        Response res = null;
        if (khachHang == null) {
            res = new Response(false, "Kh??ng t???n t???i kh??ch h??ng n??y", khachHang);
        } else
            res = new Response(true, "Th??nh c??ng", khachHang);
        Utils.responseClient(res, response);
    }

    private void getPhong(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        String cinemaId = request.getParameter("cinemaId");
        RapChieuPhim rapChieuPhim = new RapChieuPhim(Integer.parseInt(cinemaId));
        List<PhongChieu> phongChieuList = phongChieuDAO.getPhongChieu(rapChieuPhim);
        Response res = null;
        if (phongChieuList == null) {
            res = new Response(false, "???? x???y ra l???i", phongChieuList);
        } else
            res = new Response(true, "Th??nh c??ng", phongChieuList);
        Utils.responseClient(res, response);
    }

    private void getLichChieuPhimByPhim(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        String maPhim = request.getParameter("maPhim");
        Phim phim = new Phim(Integer.parseInt(maPhim));
        List<LichChieuPhim> lichChieuPhimList = lichChieuPhimDAO.getLichChieuPhim(phim);
        Response res = null;
        if (lichChieuPhimList == null) {
            res = new Response(false, "???? x???y ra l???i", lichChieuPhimList);
        } else
            res = new Response(true, "Th??nh c??ng", lichChieuPhimList);
        Utils.responseClient(res, response);
    }

    private void getLichChieuPhimByRoom(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        String maPhongChieu = request.getParameter("maPhongChieu");
        PhongChieu phongChieu = new PhongChieu(Integer.parseInt(maPhongChieu));
        List<LichChieuPhim> lichChieuPhimList = lichChieuPhimDAO.getLichChieuPhim(phongChieu);
        Response res;
        if (lichChieuPhimList == null) {
            res = new Response(false, "???? x???y ra l???i", lichChieuPhimList);
        } else
            res = new Response(true, "Th??nh c??ng", lichChieuPhimList);
        Utils.responseClient(res, response);
    }

    private void checkLogin(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ThanhVien thanhVien = new ThanhVien(username, password);
        ThanhVien thanhVienResponse = userDAO.checkLogin(thanhVien);
        Response res;
        if (thanhVienResponse != null) {
            res = new Response(true, "????ng nh???p th??nh c??ng", thanhVienResponse);
        } else {
            res = new Response(false, "Sai t??i kho???n m???t kh???u", thanhVienResponse);
        }
        Utils.responseClient(res, response);
    }

    private void createFineBill(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        String bonus, fineFee, refund, customerId, fineId, employeeId, barCode, seats, tickets;
        bonus = request.getParameter("bonus");
        fineFee = request.getParameter("fine");
        refund = request.getParameter("refund");
        customerId = request.getParameter("customerId");
        employeeId = request.getParameter("employeeId");
        fineId = request.getParameter("fineId");
        tickets = request.getParameter("ticketIds");
        barCode = request.getParameter("barCode");
        String[] ticketsArr = tickets.split(",");
        Integer cusId = Integer.parseInt(customerId);
        TheThanhVien ttv = new TheThanhVien(barCode);
        KhungPhat khungPhat = Integer.parseInt(fineId) == 0 ? null : new KhungPhat(Integer.parseInt(fineId));
        KhachHang khachHang = new KhachHang(cusId);
        khachHang.setTheThanhVien(ttv);
        System.out.println(ttv.getMaVach());
        NhanVien nhanVien = new NhanVien(Integer.parseInt(employeeId));
        HoaDonPhat hoaDonPhat = new HoaDonPhat(Integer.parseInt(bonus), Float.parseFloat(fineFee), Float.parseFloat(refund), khungPhat, cusId == 0 ? null : khachHang, nhanVien);
        List<Ve> veList = new ArrayList<>();
        for (int i = 0; i < ticketsArr.length; i++) {
            Ve ve = new Ve(Integer.parseInt(ticketsArr[i]));
            ve.setHoaDonPhat(hoaDonPhat);
            veList.add(ve);
        }
        HoaDonPhat hoaDonPhat1 = hoaDonPhatDAO.createHoaDonPhat(hoaDonPhat, veList);
        Response res;
        if (hoaDonPhat1 != null) {
            res = new Response(true, "Th??nh c??ng", hoaDonPhat1);
        } else {
            res = new Response(false, "Th???t b???i", hoaDonPhat1);
        }
        Utils.responseClient(res, response);
    }
}
