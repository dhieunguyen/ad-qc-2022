package com.example.pttk_dbclpm.dao.room;

import com.example.pttk_dbclpm.dao.DAO;
import com.example.pttk_dbclpm.dao.DatabaseConnection;
import com.example.pttk_dbclpm.model.LichChieuPhim;
import com.example.pttk_dbclpm.model.PhongChieu;
import com.example.pttk_dbclpm.model.RapChieuPhim;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhongChieuDAOImpl extends DAO implements PhongChieuDAO {
    private PreparedStatement statement;
    private Connection connection;

    public PhongChieuDAOImpl() throws SQLException {
        super();
        connection = super.connection;
    }

    @Override
    public List<PhongChieu> getPhongChieu(RapChieuPhim rapChieuPhim) {
        String query = "SELECT * FROM tblPhongChieu where maRapChieuPhim=?";
        List<PhongChieu> list = new ArrayList<>();
        PhongChieu phongChieu;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, rapChieuPhim.getMa().toString());
            rs = statement.executeQuery();
            while (rs.next()) {
                phongChieu = new PhongChieu();
                phongChieu.setMa(rs.getInt("ma"));
                phongChieu.setTenPhong(rs.getString("tenPhong"));
                phongChieu.setDacDiem(rs.getString("dacDiem"));
                phongChieu.setSoLuongGhe(rs.getInt("soLuongGhe"));
                list.add(phongChieu);
            }
        } catch (SQLException e) {
            System.out.println(e);
            list = null;
        }
        return list;
    }
}
