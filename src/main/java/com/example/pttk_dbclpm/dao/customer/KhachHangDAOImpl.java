package com.example.pttk_dbclpm.dao.customer;

import com.example.pttk_dbclpm.dao.DatabaseConnection;
import com.example.pttk_dbclpm.model.KhachHang;
import com.example.pttk_dbclpm.model.TheThanhVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDAOImpl implements KhachHangDAO {
    private PreparedStatement statement;
    private Connection connection = DatabaseConnection.getInstance().getConnection();

    public KhachHangDAOImpl() throws SQLException {
    }

    @Override
    public KhachHang getKhachHang(TheThanhVien theThanhVien) {
        String query = "SELECT kh.ma,kh.hoTen, kh.diaChi, kh.ngaySinh, kh.maTheThanhVien, ttv.maVach, ttv.diemTichLuy\n" +
                "       FROM pttk_dbclm.tblKhachHang kh\n" +
                "      inner join tblTheThanhVien ttv\n" +
                "     where ttv.maVach = ? ;";
        KhachHang khachHang = new KhachHang();
        TheThanhVien ttv;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, theThanhVien.getMaVach());
            rs = statement.executeQuery();
            if (rs.next()) {
                ttv = new TheThanhVien();
                khachHang.setMa(rs.getInt("ma"));
                khachHang.setHoTen(rs.getString("hoTen"));
                khachHang.setDiaChi(rs.getString("diaChi"));
                khachHang.setNgaySinh(rs.getDate("ngaySinh"));
                ttv.setMaVach(rs.getString("maVach"));
                ttv.setDiemTichLuy(rs.getInt("diemTichLuy"));
                ttv.setMa(rs.getInt("maTheThanhVien"));
                khachHang.setTheThanhVien(ttv);
                return khachHang;
            }
        } catch (SQLException e) {
        } finally {
            DatabaseConnection.close(rs);
            DatabaseConnection.close(statement);
            DatabaseConnection.close(statement);
        }
        return null;
    }
}
