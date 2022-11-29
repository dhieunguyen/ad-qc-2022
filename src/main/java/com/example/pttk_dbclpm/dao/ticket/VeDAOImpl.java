package com.example.pttk_dbclpm.dao.ticket;

import com.example.pttk_dbclpm.dao.DatabaseConnection;
import com.example.pttk_dbclpm.model.LichChieuPhim;
import com.example.pttk_dbclpm.model.Ve;
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
        String query = "SELECT * FROM tblVe where soGhe in (%s) and maLichChieuPhim = ?";
        List<Ve> list = new ArrayList<>();
        Ve ve;
        String sql = String.format(query, Utils.preparePlaceHolders(soGhe.length));
        System.out.println(sql);
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sql);
            for (int i = 1; i <= soGhe.length; i++) {
                statement.setString(i, soGhe[i-1]);
            }
            statement.setString(soGhe.length + 1, lichChieuPhim.getMa().toString());
            rs = statement.executeQuery();
            while (rs.next()) {
                ve = new Ve();
                ve.setMa(rs.getInt("ma"));
                ve.setSoGhe(rs.getString("soGhe"));
                ve.setGia(rs.getFloat("gia"));
                ve.setTrangThaiVe(rs.getInt("trangThai"));
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
