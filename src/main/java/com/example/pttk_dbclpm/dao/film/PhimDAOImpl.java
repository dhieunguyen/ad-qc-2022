package com.example.pttk_dbclpm.dao.film;

import com.example.pttk_dbclpm.dao.DAO;
import com.example.pttk_dbclpm.dao.DatabaseConnection;
import com.example.pttk_dbclpm.model.Phim;
import com.example.pttk_dbclpm.model.ThanhVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhimDAOImpl extends DAO implements PhimDAO {
    private PreparedStatement statement;
    private Connection connection;

    public PhimDAOImpl() throws SQLException {
        super();
        connection = super.connection;
    }
    @Override
    public List<Phim> getPhim() {
        String query = "SELECT * FROM tblPhim";
        List<Phim> list = new ArrayList<Phim>();
        Phim phim;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(query);
            rs = statement.executeQuery(query);
            while (rs.next()) {
                phim = new Phim();
                phim.setMa(rs.getInt("ma"));
                phim.setTenPhim(rs.getString("tenPhim"));
                phim.setNamSanXuat(rs.getInt("namSanXuat"));
                list.add(phim);
            }
        } catch (SQLException e) {
            list = null;
        }
        return list;
    }
}
