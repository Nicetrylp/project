package nicetry.instrument;

import nicetry.bean.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DatabaseOperate {
    public static Map<String,User> read() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "select * from data";
        Map<String, User> map = qr.query(JDBCInquire.getconn(), sql, new ResultSetHandler<Map<String, User>>() {
            @Override
            public Map<String, User> handle(ResultSet resultSet) throws SQLException {
                Map<String, User> map = new HashMap<>();
                while (resultSet.next()) {
                    User user = new User();
                    user.setName(resultSet.getString("name"));
                    String userName = resultSet.getString("userName");
                    user.setUserName(userName);
                    user.setPassword(resultSet.getString("password"));
                    map.put(userName, user);
                }
                return map;
            }
        });
        return map;
    }

    public static void write(User user) throws SQLException {
        JDBCInquire.execute(conn -> {
            String name = user.getName();
            String userName = user.getUserName();
            String password = user.getPassword();
            PreparedStatement pSta = conn.prepareStatement
                    ("INSERT INTO data VALUES (?,?,?)");
            pSta.setString(1,userName);
            pSta.setString(2,password);
            pSta.setString(3,name);
            pSta.execute();
        });
    }

    public static void show() throws SQLException {
        JDBCInquire.execute(conn -> {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM data");
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                System.out.print(resultSet.getString("name")+"\t");
                System.out.print(resultSet.getString("userName")+"\t");
                System.out.print(resultSet.getString("password")+"\t\n");
            }
        });
    }
}
