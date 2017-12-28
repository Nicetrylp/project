package com.lanou3g.userdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jbdc {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConn() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/day27";
        Connection connection = DriverManager.getConnection(url, "root", "123");
        return connection;
    }
}
