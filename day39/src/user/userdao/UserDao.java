package user.userdao;

import org.apache.commons.dbutils.handlers.BeanHandler;
import user.bean.User;
import util.C3P0Util;
import util.LPQueryRunner;

import java.sql.SQLException;

public class UserDao {
    public int insert(User user){
        String sql = "insert into user values(?,?)";
        int i = 0;
        try {
            i = new LPQueryRunner().update(C3P0Util.getConnection(),
                    sql,
                    user.getUsername(), user.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    public User select(String username){
        String sql = "select * from user where username = ?";
        User user = null;
        try {
            user = new LPQueryRunner().query(C3P0Util.getConnection(),
                    sql,
                    new BeanHandler<User>(User.class),
                    username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
