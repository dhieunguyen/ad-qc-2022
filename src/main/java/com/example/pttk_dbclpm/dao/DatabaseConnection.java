package com.example.pttk_dbclpm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

import static com.example.pttk_dbclpm.constant.Constant.DAOConstant.*;

public class DatabaseConnection {

  private static DatabaseConnection instance;
  private Connection connection;

  private DatabaseConnection() {
    try {
      Class.forName(DRIVER);
      this.connection = DriverManager.getConnection(URI, USER, PASSWORD);
    } catch (ClassNotFoundException | SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public Connection getConnection() {
    return connection;
  }

  public static DatabaseConnection getInstance() throws SQLException {
    if (Objects.isNull(instance)) {
      instance = new DatabaseConnection();
    } else if (instance.getConnection().isClosed()) {
      instance = new DatabaseConnection();
    }
    return instance;
  }
}
