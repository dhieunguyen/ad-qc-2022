package dao;

import com.example.pttk_dbclpm.dao.DAO;
import com.example.pttk_dbclpm.dao.DatabaseConnection;
import com.example.pttk_dbclpm.model.HoaDonPhat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TheThanhVienDAOImpl extends DAO implements TheThanhVienDAOTest {
    private PreparedStatement statement;
    private Connection connection;

    public TheThanhVienDAOImpl() throws SQLException {
        super();
        connection = super.connection;
    }

    @Override
    public boolean updateDiemTichLuy(HoaDonPhat hoaDonPhat) {
        boolean isSuccess = false;
        String query = "UPDATE tblTheThanhVien " +
                "SET diemTichLuy = diemTichLuy + ? WHERE maVach = ?";
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(query);
            System.out.println(statement.toString());
            System.out.println(hoaDonPhat.toString());
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
        } finally {

        }
        return isSuccess;
    }
}
