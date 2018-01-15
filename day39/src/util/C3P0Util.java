package util;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Created by travelround on 17/4/18.
 */
public class C3P0Util {
    // 得到一个数据源(连接池)
    private static DataSource dataSource = new ComboPooledDataSource();

    /**
     * 获得一个connection
     */
    public static Connection getConnection() {
        try {
            // 通过dataSource的getConnection方法获得连接,
            // 将连接返回给外界
            return dataSource.getConnection();
        } catch (SQLException e) {
            // 如果在获得连接时 出现异常,会在运行时,输出服务器忙
            throw new RuntimeException("服务器忙...");
        }
    }

    public static void release(ResultSet resultSet, Statement stmt, Connection connection) {
        // 如果结果集不为空,说明结果集没被关闭,使用close关闭结果集
        // 并将结果集设置为空
        if (resultSet != null) {
            try {
                // 关闭结果集
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // 将结果集设为空
            resultSet = null;
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        // 关闭connection,并将connection设为null
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
        }
    }
}
