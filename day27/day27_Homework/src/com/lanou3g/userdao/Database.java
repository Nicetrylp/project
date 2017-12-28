package com.lanou3g.userdao;

import com.lanou3g.bean.User;
import net.sf.json.JSONArray;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Database {
    public static JSONArray select() throws SQLException {
        /**
         * 访问数据库,获取所有信息
         */
        List<User> users = new QR().query(Jbdc.getConn(),
                "select * from user",
                new BeanListHandler<User>(User.class));
        JSONArray jsonArray = JSONArray.fromObject(users);
        return jsonArray;
    }

    /**
     * 访问数据库,添加信息
     */
    public static int add(String username,String gender) throws SQLException {
        int i = new QR().update(Jbdc.getConn(),
                "insert into user values(null,?,?)",
                username, gender
        );
        return i;
    }
}
