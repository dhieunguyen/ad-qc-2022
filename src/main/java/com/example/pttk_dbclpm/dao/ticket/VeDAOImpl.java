package com.example.pttk_dbclpm.dao.ticket;

import com.example.pttk_dbclpm.dao.DAO;
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

public class VeDAOImpl extends DAO implements VeDAO {
    private PreparedStatement statement;
    private Connection connection;

    public VeDAOImpl() throws SQLException {
        super();
        connection = super.connection;
    }
    public VeDAOImpl(Connection connection) throws SQLException {
        this.connection = connection;
    }
    @Override
    public List<Ve> getVe(LichChieuPhim lichChieuPhim, List<Ve> veList) {
//        String query = "SELECT * FROM tblVe where soGhe in (%s) and maLichChieuPhim = ?";
        String query = "SELECT v.ma, v.soGhe, v.uuDai,v.gia,v.trangThai,v.diemThuong,\n" +
                "tblLichChieuPhim.ngayChieu,tblLichChieuPhim.gioBatDau,tblLichChieuPhim.gioKetThuc,\n" +
                "tblPhongChieu.tenPhong,\n" +
                "tblRapChieuPhim.ten,\n" +
                "tblPhim.tenPhim\n" +
                "FROM tblVe v \n" +
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
        String sql = String.format(query, Utils.preparePlaceHolders(veList.size()));
        System.out.println(sql);
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sql);
            for (int i = 1; i <= veList.size(); i++) {
                statement.setString(i, veList.get(i - 1).getSoGhe());
            }
            statement.setString(veList.size() + 1, lichChieuPhim.getMa().toString());
            rs = statement.executeQuery();
            while (rs.next()) {
                ve = new Ve();
                rapChieuPhim = new RapChieuPhim();
                lichChieuPhimRes = new LichChieuPhim();
                phim = new Phim();
                phongChieu = new PhongChieu();
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
                lichChieuPhimRes.setGioBatDau(rs.getTime("gioBatDau"));
                lichChieuPhimRes.setGioKetThuc(rs.getTime("gioKetThuc"));
                lichChieuPhimRes.setPhim(phim);
                lichChieuPhimRes.setPhongChieu(phongChieu);
                ve.setLichChieuPhim(lichChieuPhimRes);
                list.add(ve);
            }
        } catch (SQLException e) {
            System.out.println(e);
            list = null;
        }
        return list;
    }

    @Override
    public boolean updateTrangThaiVe(List<Ve> listVe) {
        boolean isSuccess = false;
        String query = "UPDATE tblVe " +
                "SET trangThai = 0, maHoaDonPhat = ? WHERE ma = ?";
        String sql = String.format(query, Utils.preparePlaceHolders(listVe.size()));
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
//            statement.setString(1, listVe.get(0).getHoaDonPhat().getMa().toString());
//            for (int i = 1; i <= listVe.size(); i++) {
//                statement.setString(i + 1, listVe.get(i - 1).getMa().toString());
//            }
            for (int i = 0; i < listVe.size(); i++) {
                statement.setString(1, listVe.get(i).getHoaDonPhat().getMa().toString());
                statement.setString(2, listVe.get(i).getMa().toString());
                statement.addBatch();
            }
            System.out.println(statement.toString());
            statement.executeBatch();
            System.out.println(statement.toString());
            isSuccess = true;
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            isSuccess = false;
            System.out.println(e);
        }
        return isSuccess;
    }
}
