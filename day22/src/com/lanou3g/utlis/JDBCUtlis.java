package com.lanou3g.utlis;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtlis {

    static {
        // 注册驱动
        try {
            Properties prop = new Properties();
            prop.load(new FileReader("src/jdbc.properties"));
            String driverName =prop.getProperty("driverName");
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            database = prop.getProperty("database");
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage()+"\n\t\t"+"请将配置文件jdbc.properties放置到src目录下");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String url;
    private static String user;
    private static String password;
    private static String database;
    private static Connection connection;


    public static Connection getconn( )throws SQLException{
        try {
            // 获取连接
            String url1 = url + database;
            connection = DriverManager.getConnection(url1,user,password);
            return connection;
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    public static void execute(ExecuteInter e){
        try {
            // 获取连接
            String url1 = url + database;
            Connection connection = DriverManager.getConnection(url1,user,password);
            // 这个关闭很灵性
            e.execute(connection).close();
            connection.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    // 遍历
    public static void showRs(ResultSet resultSet){
        try {
            while (resultSet.next()){
                System.out.print(resultSet.getString(1) + "\t");
                System.out.print(resultSet.getString(2) + "\t");
                System.out.print(resultSet.getString(3) + "\t");
                System.out.print(resultSet.getString(4) + "\t\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
