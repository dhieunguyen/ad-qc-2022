package dao;

import com.example.pttk_dbclpm.dao.DAO;
import com.example.pttk_dbclpm.dao.DatabaseConnection;
import com.example.pttk_dbclpm.model.*;
import com.example.pttk_dbclpm.utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeDAOImpl extends DAO implements VeDAODAOTest {
    private PreparedStatement statement;
    private Connection connection ;

    public VeDAOImpl() throws SQLException {
        super();
        connection = super.connection;
    }

    @Override
    public boolean updateTrangThaiVe(List<Ve> listVe) {
        boolean isSuccess = false;
        String query = "UPDATE tblVe " +
                "SET trangThai = 1, maHoaDonPhat = NULL WHERE ma = ?";
        String sql = String.format(query, Utils.preparePlaceHolders(listVe.size()));
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < listVe.size(); i++) {
                statement.setString(1, listVe.get(i).getMa().toString());
                statement.addBatch();
            }
            statement.executeBatch();
            System.out.println(statement.toString());
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
