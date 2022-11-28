package com.example.pttk_dbclpm.dao.schedule;

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

public class LichChieuPhimDAOImpl implements LichChieuPhimDAO {
    private PreparedStatement statement;
    private Connection connection = DatabaseConnection.getInstance().getConnection();

    public LichChieuPhimDAOImpl() throws SQLException {
    }

    @Override
    public List<LichChieuPhim> getLichChieuPhim(Phim phim) {
        String query = "SELECT * FROM tblLichChieuPhim where maPhim=?";
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
                lichChieuPhim.setGioChieu(rs.getString("gioChieu"));
                list.add(lichChieuPhim);
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


    @Override
    public List<LichChieuPhim> getLichChieuPhim(PhongChieu phongChieu) {
        String query = "SELECT * FROM tblLichChieuPhim where maPhongChieu=?";
        List<LichChieuPhim> list = new ArrayList<LichChieuPhim>();
        LichChieuPhim lichChieuPhim;
        ResultSet rs = null;

        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, phongChieu.getMa().toString());
            rs = statement.executeQuery(query);
            while (rs.next()) {
                Date ngayChieu = new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString("ngayChieu"));
                lichChieuPhim = new LichChieuPhim();
                lichChieuPhim.setMa(rs.getInt("ma"));
                lichChieuPhim.setNgayChieu(ngayChieu);
                lichChieuPhim.setGioChieu(rs.getString("gioChieu"));
                list.add(lichChieuPhim);
            }
        } catch (SQLException e) {
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            DatabaseConnection.close(rs);
            DatabaseConnection.close(statement);
            DatabaseConnection.close(statement);
        }
        return list;
    }
}