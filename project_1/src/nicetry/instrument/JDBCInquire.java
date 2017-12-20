package nicetry.instrument;

import nicetry.implement.ExecuteInter;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCInquire {
    static {
        try {
            Properties pro = new Properties();
            pro.load(new FileReader("src/jdbc.properties"));
            String driverName = pro.getProperty("driverName");
            database = pro.getProperty("database");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            url = pro.getProperty("url");
            Class.forName(driverName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String database;
    private static String user;
    private static String password;
    private static String url;

    public static void execute(ExecuteInter e) throws SQLException {
        Connection connection = DriverManager.getConnection(url + database, user, password);
        e.excuter(connection);
        connection.close();
    }

    public static Connection getconn(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url + database, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
