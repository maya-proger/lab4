package org.majic.services;

import java.sql.*;

public class DBService {


    private Connection getConnect() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        final String url = "jdbc:postgresql://localhost:5432/majic";
        final String user = "postgres";
        final String password = "root";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public ResultSet makeQuery(String sql) {
        Connection connection = getConnect();
        Statement statement = null;
        ResultSet rs;
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            return rs;
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            return null;
        }
    }

}