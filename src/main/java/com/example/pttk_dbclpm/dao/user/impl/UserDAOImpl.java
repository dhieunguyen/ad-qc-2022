package com.example.pttk_dbclpm.dao.user.impl;

import com.example.pttk_dbclpm.dao.DatabaseConnection;
import com.example.pttk_dbclpm.dao.user.UserDAO;
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
        String query = "SELECT * FROM tblThanhVien";
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
    public boolean checkLogin(ThanhVien thanhVien) {
        String query = "SELECT * FROM tblThanhVien where tenDangNhap=? and matKhau=?";
        ResultSet rs = null;
        System.out.println("runningg");
        boolean isLoggedIn = false;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1,thanhVien.getTenDangNhap());
            statement.setString(2,thanhVien.getMatKhau());
            rs = statement.executeQuery();
            isLoggedIn = rs.next();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DatabaseConnection.close(rs);
            DatabaseConnection.close(statement);
            DatabaseConnection.close(statement);
        }
        return isLoggedIn;
    }
}
