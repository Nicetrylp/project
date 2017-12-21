package com.lanou3g.instrument;

import com.lanou3g.study.User;
import com.lanou3g.study.WHQueryRunner;
import com.lanou3g.utlis.JDBCUtlis;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class UserInstrument {
    // 增
    public static void add(String name,String loc,int age) throws SQLException {
        int i = new WHQueryRunner().update(
                JDBCUtlis.getconn(),
                "insert into hw_user values(null,?,?,?)",
                name, age, loc
        );
        System.out.println("添加成功," + i +"行受到影响");
    }
    // 删
    public static void drop(String name) throws SQLException {
        int i = new WHQueryRunner().update(
                JDBCUtlis.getconn(),
                "delete from hw_user where uname = ?",
                name
        );
        System.out.println("删除成功"+ i +"行受到影响");
    }
    // 改
    public static void update(String name,String loc,int age, int id) throws SQLException {
        int i = new WHQueryRunner().update(
                JDBCUtlis.getconn(),
                "update hw_user set uname = ?,loc = ?,age = ? where uid = ?",
                name, loc, age, id
        );
        System.out.println("修改成功 " + i +"行受到影响");
    }
    // 查
    public static void query() throws SQLException {
        List<User> query = new WHQueryRunner().query(
                JDBCUtlis.getconn(),
                "select * from hw_user",
                new BeanListHandler<User>(User.class)
        );
        for (User user : query) {
            System.out.println(user);
        }
    }
    // 条件查询id
    public static void query(int id)throws SQLException{
        User query = new WHQueryRunner().query(
                JDBCUtlis.getconn(),
                "select * from hw_user where uid = ?",
                new BeanHandler<User>(User.class),
                id
        );
        System.out.println(query);
    }
}
