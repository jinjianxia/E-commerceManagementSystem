package com.util;

import java.sql.*;

public class DBUtil {
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;

    String driver = ConfigManager.getInstance().getString("driver");
    String url = ConfigManager.getInstance().getString("url");
    String username = ConfigManager.getInstance().getString("username");
    String password = ConfigManager.getInstance().getString("password");

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public ResultSet executeQuery(String sql, Object[] o) {
        connection = getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < o.length; i++) {
                preparedStatement.setObject(i + 1, o[i]);
            }
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public int executeUpdate(String sql, Object[] o) {
        connection = getConnection();
        int result = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < o.length; i++) {
                preparedStatement.setObject(i + 1, o[i]);
            }
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void closeAll() {
        try {
            if (resultSet != null)
                resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
