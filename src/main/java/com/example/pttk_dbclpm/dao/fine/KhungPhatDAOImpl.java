package com.example.pttk_dbclpm.dao.fine;

import com.example.pttk_dbclpm.dao.DAO;
import com.example.pttk_dbclpm.dao.DatabaseConnection;
import com.example.pttk_dbclpm.model.KhungPhat;
import com.example.pttk_dbclpm.model.LichChieuPhim;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KhungPhatDAOImpl extends DAO implements KhungPhatDAO {
    private PreparedStatement statement;
    private Connection connection;

    public KhungPhatDAOImpl() throws SQLException {
        super();
        connection = super.connection;
    }

    @Override
    public KhungPhat getKhungPhat(int gio) {
        String query = "SELECT * FROM pttk_dbclm.tblKhungPhat kp where kp.khungGio <= ? limit 1;";
        KhungPhat khungPhat = new KhungPhat();
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, String.valueOf(gio));
            rs = statement.executeQuery();
            if (rs.next()) {
                khungPhat.setMa(rs.getInt("ma"));
                khungPhat.setKhungGio(rs.getInt("khungGio"));
                khungPhat.setPhi(rs.getFloat("phi"));
                return khungPhat;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
