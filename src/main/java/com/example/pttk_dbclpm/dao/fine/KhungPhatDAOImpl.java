package com.example.pttk_dbclpm.dao.fine;

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

public class KhungPhatDAOImpl implements KhungPhatDAO {
    private PreparedStatement statement;
    private Connection connection = DatabaseConnection.getInstance().getConnection();

    public KhungPhatDAOImpl() throws SQLException {
    }

    @Override
    public List<KhungPhat> getKhungPhat(int gio) {
        String query = "SELECT * FROM pttk_dbclm.tblKhungPhat kp where kp.khungGio <= ? limit 1;";
        List<KhungPhat> list = new ArrayList<>();
        KhungPhat khungPhat;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, String.valueOf(gio));
            rs = statement.executeQuery();
            while (rs.next()) {
                khungPhat = new KhungPhat();
                khungPhat.setMa(rs.getInt("ma"));
                khungPhat.setKhungGio(rs.getInt("khungGio"));
                khungPhat.setPhi(rs.getFloat("phi"));
                list.add(khungPhat);
            }
        } catch (SQLException e) {
            System.out.println(e);
            list = null;
        } finally {
            DatabaseConnection.close(rs);
            DatabaseConnection.close(statement);
            DatabaseConnection.close(statement);
        }
        return list;
    }
}
