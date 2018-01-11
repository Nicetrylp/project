package com.nicetry.bookstore.user.dao;

import com.nicetry.bookstore.user.domain.User;
import com.nicetry.bookstore.util.DBCPUtil;
import com.nicetry.bookstore.util.LPQueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;


public class UserDao {
    public User queryByName(String username){
        try {
            User user = new LPQueryRunner().query(DBCPUtil.getConnection(),
                    "select * from user where username = ?",
                    new BeanHandler<User>(User.class),
                    username);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void insertUser(User user){
        try {
            new LPQueryRunner().update(DBCPUtil.getConnection(),
                    "insert into user values(?,?,?,?,?,?)",
                    user.getUid(),user.getUsername(),user.getPassword(),
                    user.getEmail(),user.getCode(),user.isState());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void removeUser(){

    }
    public void updataUser(User user){

    }
    public int updateStateByCode(String code){
        int update = 0;
        try {
            update = new LPQueryRunner().update(DBCPUtil.getConnection(),
                    "update user set state = true where code = ?",
                    code);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }
    public User queryByEmail(String email){
        try {
            User user = new LPQueryRunner().query(DBCPUtil.getConnection(),
                    "select * from user where username = ?",
                    new BeanHandler<User>(User.class),
                    email);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
