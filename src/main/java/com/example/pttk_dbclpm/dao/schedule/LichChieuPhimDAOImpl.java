package com.example.pttk_dbclpm.dao.schedule;

import com.example.pttk_dbclpm.dao.DAO;
import com.example.pttk_dbclpm.dao.DatabaseConnection;
import com.example.pttk_dbclpm.model.LichChieuPhim;
import com.example.pttk_dbclpm.model.Phim;
import com.example.pttk_dbclpm.model.PhongChieu;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LichChieuPhimDAOImpl extends DAO implements LichChieuPhimDAO {
    private PreparedStatement statement;
    private Connection connection;

    public LichChieuPhimDAOImpl() throws SQLException {
        super();
        connection = super.connection;
    }

    @Override
    public List<LichChieuPhim> getLichChieuPhim(Phim phim) {
        String query = "SELECT * FROM tblLichChieuPhim where maPhim=? and cast(concat(ngayChieu, ' ', gioBatDau) as datetime) >= now()";
        List<LichChieuPhim> list = new ArrayList<>();
        LichChieuPhim lichChieuPhim;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, phim.getMa().toString());
            rs = statement.executeQuery();
            while (rs.next()) {
                Date ngayChieu = rs.getDate("ngayChieu");
                lichChieuPhim = new LichChieuPhim();
                lichChieuPhim.setMa(rs.getInt("ma"));
                lichChieuPhim.setNgayChieu(ngayChieu);
                lichChieuPhim.setGioBatDau(rs.getTime("gioBatDau"));
                lichChieuPhim.setGioKetThuc(rs.getTime("gioKetThuc"));
                list.add(lichChieuPhim);
            }
        } catch (SQLException e) {
            System.out.println(e);
            list = null;
        } finally {
        }
        return list;
    }


    @Override
    public List<LichChieuPhim> getLichChieuPhim(PhongChieu phongChieu) {
        String query = "SELECT * FROM tblLichChieuPhim where maPhongChieu=? and cast(concat(ngayChieu, ' ', gioBatDau) as datetime) >= now()";
        List<LichChieuPhim> list = new ArrayList<LichChieuPhim>();
        LichChieuPhim lichChieuPhim;
        ResultSet rs = null;

        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, phongChieu.getMa().toString());
            rs = statement.executeQuery();
            while (rs.next()) {
                Date ngayChieu = rs.getDate("ngayChieu");
                lichChieuPhim = new LichChieuPhim();
                lichChieuPhim.setMa(rs.getInt("ma"));
                lichChieuPhim.setNgayChieu(ngayChieu);
                lichChieuPhim.setGioBatDau(rs.getTime("gioBatDau"));
                lichChieuPhim.setGioKetThuc(rs.getTime("gioKetThuc"));
                list.add(lichChieuPhim);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {

        }
        return list;
    }
}
