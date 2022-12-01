package com.example.pttk_dbclpm.dao.user.impl;

import com.example.pttk_dbclpm.dao.DatabaseConnection;
import com.example.pttk_dbclpm.dao.user.UserDAO;
import com.example.pttk_dbclpm.model.RapChieuPhim;
import com.example.pttk_dbclpm.model.ThanhVien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private PreparedStatement statement;
    private Connection connection = DatabaseConnection.getInstance().getConnection();

    public UserDAOImpl() throws SQLException {
    }

    @Override
    public List<ThanhVien> getThanhVien() {
        String query = "SELECT * from tblThanhVien";
        List<ThanhVien> list = new ArrayList<ThanhVien>();
        ThanhVien thanhVien;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(query);
            rs = statement.executeQuery(query);
            while (rs.next()) {
                thanhVien = new ThanhVien();
                thanhVien.setMa(rs.getInt("ma"));
                thanhVien.setHoTen(rs.getString("hoTen"));
                thanhVien.setEmail(rs.getString("ngaySinh"));
                thanhVien.setEmail(rs.getString("email"));
                thanhVien.setEmail(rs.getString("soDienThoai"));
                list.add(thanhVien);
            }
        } catch (SQLException e) {
        } finally {
            DatabaseConnection.close(rs);
            DatabaseConnection.close(statement);
            DatabaseConnection.close(statement);
        }
        return list;
    }

    @Override
    public List<ThanhVien> checkLogin(ThanhVien thanhVien) {
        String query = "SELECT tv.ma,tv.hoTen,tv.ngaySinh,tv.soDienThoai,tv.email, tv.maRapChieuPhim, tblRapChieuPhim.ten FROM \n" +
                "tblThanhVien tv INNER JOIN tblNhanVien ON tblNhanVien.maThanhVien=tv.ma \n" +
                "INNER JOIN tblRapChieuPhim on tblRapChieuPhim.ma = tv.maRapChieuPhim where tenDangNhap=? and matKhau=?";
        ResultSet rs = null;
        List<ThanhVien> list = new ArrayList<ThanhVien>();
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, thanhVien.getTenDangNhap());
            statement.setString(2, thanhVien.getMatKhau());
            rs = statement.executeQuery();
            while (rs.next()) {
                ThanhVien thanhVienResponse = new ThanhVien();
                RapChieuPhim rapChieuPhim = new RapChieuPhim();
                thanhVienResponse.setMa(rs.getInt("ma"));
                thanhVienResponse.setHoTen(rs.getString("hoTen"));
                thanhVienResponse.setNgaySinh(rs.getDate("ngaySinh"));
                thanhVienResponse.setEmail(rs.getString("email"));
                thanhVienResponse.setSoDienThoai(rs.getString("soDienThoai"));
                rapChieuPhim.setMa(rs.getInt("maRapChieuPhim"));
                rapChieuPhim.setTen(rs.getString("ten"));
                thanhVienResponse.setRapChieuPhim(rapChieuPhim);
                list.add(thanhVienResponse);
            }

        } catch (SQLException e) {
            System.out.println(e);
            list = null;
        } finally {
            DatabaseConnection.close(rs);
            DatabaseConnection.close(statement);
            DatabaseConnection.close(statement);
        }
        return list;
    }
}
