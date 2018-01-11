package com.nicetry.bookstore.util;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBCPUtil {
    private static Properties properties = new Properties();
    private static DataSource dataSource;
    // 加载DBCP配置文件
    static{
        ClassLoader classLoader = DBCPUtil.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("dbcp.properties");
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 从连接池中获取一个数据
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
             // 开启事物
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
