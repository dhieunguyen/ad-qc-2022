package com.example.pttk_dbclpm.dao.membership;

import com.example.pttk_dbclpm.dao.DAO;
import com.example.pttk_dbclpm.dao.DatabaseConnection;
import com.example.pttk_dbclpm.model.HoaDonPhat;
import com.example.pttk_dbclpm.model.KhachHang;
import com.example.pttk_dbclpm.utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TheThanhVienDAOImpl extends DAO implements TheThanhVienDAO {
    private PreparedStatement statement;
    private Connection connection;

    public TheThanhVienDAOImpl() throws SQLException {
        super();
        connection = super.connection;
    }
    public TheThanhVienDAOImpl(Connection connection) throws SQLException {
       this.connection = connection;
    }

    @Override
    public boolean updateDiemTichLuy(HoaDonPhat hoaDonPhat) {
        boolean isSuccess = false;
        String query = "UPDATE tblTheThanhVien " +
                "SET diemTichLuy = diemTichLuy - ? WHERE maVach = ?";
        System.out.println(hoaDonPhat.getKhachHang().getTheThanhVien().getMaVach());
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(query);
            statement.setString(1, hoaDonPhat.getDiemBiTru().toString());
            statement.setString(2, hoaDonPhat.getKhachHang().getTheThanhVien().getMaVach());
            statement.executeUpdate();
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
