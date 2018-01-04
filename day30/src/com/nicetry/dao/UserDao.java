package com.nicetry.dao;

import com.nicetry.bean.User;
import com.nicetry.util.Jdbc;
import com.nicetry.util.LPQueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {
    public static int insertServlet(User user) throws SQLException {
        int i = new LPQueryRunner().update(Jdbc.getConn(),
                "insert into user values(null,?,?,?)",
                user.getUsername(), user.getPassword(), user.getNickname());
        return i;
    }
    public static User selectServlet(String username) throws SQLException {
        User user = new LPQueryRunner().query(Jdbc.getConn(),
                "select * from user where username = ?",
                new BeanHandler<User>(User.class),
                username);
        return user;
    }
}
