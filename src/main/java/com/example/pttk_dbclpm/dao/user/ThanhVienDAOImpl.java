package com.example.pttk_dbclpm.dao.user;

import com.example.pttk_dbclpm.dao.DAO;
import com.example.pttk_dbclpm.dao.DatabaseConnection;
import com.example.pttk_dbclpm.model.RapChieuPhim;
import com.example.pttk_dbclpm.model.ThanhVien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ThanhVienDAOImpl extends DAO implements ThanhVienDAO {
    private PreparedStatement statement;
    private Connection connection;

    public ThanhVienDAOImpl() throws SQLException {
        super();
        connection = super.connection;
    }

    @Override
    public ThanhVien checkLogin(ThanhVien thanhVien) {
        String query = "SELECT tv.ma,tv.hoTen,tv.ngaySinh,tv.soDienThoai,tv.email, tv.maRapChieuPhim,tv.tenDangNhap, tblRapChieuPhim.ten FROM \n" +
                "tblThanhVien tv INNER JOIN tblNhanVien ON tblNhanVien.maThanhVien=tv.ma \n" +
                "INNER JOIN tblRapChieuPhim on tblRapChieuPhim.ma = tv.maRapChieuPhim where tenDangNhap=? and matKhau=?";
        ResultSet rs = null;
        ThanhVien thanhVienResponse = new ThanhVien();
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, thanhVien.getTenDangNhap());
            statement.setString(2, thanhVien.getMatKhau());
            rs = statement.executeQuery();
            if (rs.next()) {
                RapChieuPhim rapChieuPhim = new RapChieuPhim();
                thanhVienResponse.setMa(rs.getInt("ma"));
                thanhVienResponse.setTenDangNhap(rs.getString("tenDangNhap"));
                thanhVienResponse.setHoTen(rs.getString("hoTen"));
                thanhVienResponse.setNgaySinh(rs.getDate("ngaySinh"));
                thanhVienResponse.setEmail(rs.getString("email"));
                thanhVienResponse.setSoDienThoai(rs.getString("soDienThoai"));
                rapChieuPhim.setMa(rs.getInt("maRapChieuPhim"));
                rapChieuPhim.setTen(rs.getString("ten"));
                thanhVienResponse.setRapChieuPhim(rapChieuPhim);
                return thanhVienResponse;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
