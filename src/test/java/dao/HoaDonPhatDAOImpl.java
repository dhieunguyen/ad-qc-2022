package dao;

import com.example.pttk_dbclpm.dao.DAO;
import com.example.pttk_dbclpm.dao.DatabaseConnection;
import com.example.pttk_dbclpm.model.HoaDonPhat;
import com.example.pttk_dbclpm.model.Ve;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HoaDonPhatDAOImpl extends DAO implements HoaDonPhatDAOTest {
    private PreparedStatement statement;
    private Connection connection;
    String DELETE_BY_ID = "DELETE FROM tblHoaDonPhat hdp WHERE hdp.ma = ?";

    public HoaDonPhatDAOImpl() throws SQLException {
        super();
        connection = super.connection;
    }
    @Override
    public boolean deleteHoaDonPhat(int id) throws SQLException {
        Connection conn = null;
        try {
            conn = super.connection;
            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            int row = preparedStatement.executeUpdate();
            if (row == 0) throw new SQLException();
            conn.commit();
            return true;
        } catch (SQLException e) {
            conn.rollback();
            throw new RuntimeException(e);
        } finally {
            conn.setAutoCommit(true);
        }
    }
}
