package com.example.pttk_dbclpm.dao.fine_bill;

import com.example.pttk_dbclpm.dao.DatabaseConnection;
import com.example.pttk_dbclpm.dao.membership.TheThanhVienDAOImpl;
import com.example.pttk_dbclpm.dao.ticket.VeDAOImpl;
import com.example.pttk_dbclpm.model.HoaDonPhat;
import com.example.pttk_dbclpm.model.KhungPhat;
import com.example.pttk_dbclpm.model.Ve;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HoaDonPhatDAOImpl implements HoaDonPhatDAO {
    private PreparedStatement statement;
    private Connection connection = DatabaseConnection.getInstance().getConnection();

    public HoaDonPhatDAOImpl() throws SQLException {
    }

    @Override
    public HoaDonPhat createHoaDonPhat(HoaDonPhat hoaDonPhat, List<Ve> veList) {
        String query = "INSERT INTO `pttk_dbclm`.`tblHoaDonPhat` (`diemBiTru`, `tienPhat`, `tienHoanLai`, `maKhachHang`, `maNhanVien`, `maKhungPhat`)\n" +
                "VALUES (?, ?, ?, ?, ?, ?);";
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, hoaDonPhat.getDiemBiTru().toString());
            statement.setString(2, hoaDonPhat.getTienPhat().toString());
            statement.setString(3, hoaDonPhat.getTienHoanLai().toString());
            if (hoaDonPhat.getKhachHang() != null)
                statement.setString(4, hoaDonPhat.getKhachHang().getMa().toString());
            else statement.setString(4, null);
            statement.setString(5, hoaDonPhat.getNhanVien().getMa().toString());
            if (hoaDonPhat.getKhungPhat() != null)
                statement.setString(6, hoaDonPhat.getKhungPhat().getMa().toString());
            else statement.setString(6, null);
            statement.executeUpdate();
            if (hoaDonPhat.getKhachHang() != null) {
                TheThanhVienDAOImpl theThanhVienDAO = new TheThanhVienDAOImpl();
                theThanhVienDAO.updateDiemTichLuy(hoaDonPhat);
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    long id = generatedKeys.getLong(1);
                    VeDAOImpl veDAO = new VeDAOImpl();
                    veList.get(0).getHoaDonPhat().setMa((int) id);
                    boolean isTicketUpdated = veDAO.updateTrangThaiVe(veList);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
            connection.commit();
            return hoaDonPhat;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            DatabaseConnection.close(statement);
            DatabaseConnection.close(statement);
        }
        return null;
    }
}
