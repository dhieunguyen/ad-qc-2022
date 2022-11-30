package com.example.pttk_dbclpm.dao.ticket;

import com.example.pttk_dbclpm.dao.DatabaseConnection;
import com.example.pttk_dbclpm.model.*;
import com.example.pttk_dbclpm.utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VeDAOImpl implements VeDAO {
    private PreparedStatement statement;
    private Connection connection = DatabaseConnection.getInstance().getConnection();

    public VeDAOImpl() throws SQLException {
    }

    @Override
    public List<Ve> getVe(LichChieuPhim lichChieuPhim, String[] soGhe) {
//        String query = "SELECT * FROM tblVe where soGhe in (%s) and maLichChieuPhim = ?";
        String query = "SELECT v.ma, v.soGhe, v.uuDai,v.gia,v.trangThai,v.diemThuong,tblHoaDon.ngayTao,\n" +
                "tblLichChieuPhim.ngayChieu,tblLichChieuPhim.gioChieu,\n" +
                "tblPhongChieu.tenPhong,\n" +
                "tblRapChieuPhim.ten,\n" +
                "tblPhim.tenPhim\n" +
                "FROM tblVe v \n" +
                "inner join tblHoaDon on v.maHoaDon = tblHoaDon.ma\n" +
                "inner join tblLichChieuPhim on v.maLichChieuPhim = tblLichChieuPhim.ma\n" +
                "inner join tblPhongChieu on tblLichChieuPhim.maPhongChieu = tblPhongChieu.ma\n" +
                "inner join tblRapChieuPhim on tblPhongChieu.maRapChieuPhim = tblRapChieuPhim.ma\n" +
                "inner join tblPhim on tblLichChieuPhim.maPhim = tblPhim.ma\n" +
                "where soGhe in (%s) and maLichChieuPhim = ?;";
        List<Ve> list = new ArrayList<>();
        Ve ve;
        RapChieuPhim rapChieuPhim;
        LichChieuPhim lichChieuPhimRes;
        Phim phim;
        PhongChieu phongChieu;
        HoaDon hoaDon;
        String sql = String.format(query, Utils.preparePlaceHolders(soGhe.length));
        System.out.println(sql);
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sql);
            for (int i = 1; i <= soGhe.length; i++) {
                statement.setString(i, soGhe[i - 1]);
            }
            statement.setString(soGhe.length + 1, lichChieuPhim.getMa().toString());
            rs = statement.executeQuery();
            while (rs.next()) {
                ve = new Ve();
                rapChieuPhim = new RapChieuPhim();
                lichChieuPhimRes = new LichChieuPhim();
                phim = new Phim();
                phongChieu = new PhongChieu();
                hoaDon = new HoaDon();
                ve.setMa(rs.getInt("ma"));
                ve.setSoGhe(rs.getString("soGhe"));
                ve.setUuDai(rs.getInt("uuDai"));
                ve.setGia(rs.getFloat("gia"));
                ve.setTrangThaiVe(rs.getInt("trangThai"));
                ve.setDiemThuong(rs.getInt("diemThuong"));
                rapChieuPhim.setTen(rs.getString("ten"));
                phongChieu.setTenPhong(rs.getString("tenPhong"));
                phongChieu.setRapChieuPhim(rapChieuPhim);
                phim.setTenPhim(rs.getString("tenPhim"));
                lichChieuPhimRes.setNgayChieu(rs.getDate("ngayChieu"));
                lichChieuPhimRes.setGioChieu(rs.getString("gioChieu"));
                lichChieuPhimRes.setPhim(phim);
                lichChieuPhimRes.setPhongChieu(phongChieu);
                hoaDon.setNgayTao(rs.getDate("ngayTao"));
                ve.setLichChieuPhim(lichChieuPhimRes);
                ve.setHoaDon(hoaDon);
                list.add(ve);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DatabaseConnection.close(rs);
            DatabaseConnection.close(statement);
            DatabaseConnection.close(statement);
        }
        return list;
    }
}
