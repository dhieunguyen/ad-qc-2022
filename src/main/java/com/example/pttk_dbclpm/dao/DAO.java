package com.example.pttk_dbclpm.dao;

import java.sql.*;

import static com.example.pttk_dbclpm.constant.Constant.DAOConstant.*;

public class DAO {
    protected Connection connection;
    public DAO() {
        try {
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(URI, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {

            }
        }
    }
    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {

            }
        }
    }
    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {

            }
        }
    }
}
