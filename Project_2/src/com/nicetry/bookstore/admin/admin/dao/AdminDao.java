package com.nicetry.bookstore.admin.admin.dao;

import com.nicetry.bookstore.admin.admin.domain.Admin;
import com.nicetry.bookstore.util.DBCPUtil;
import com.nicetry.bookstore.util.LPQueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class AdminDao {
    public Admin queryByName(String adminName) {
        String sql = "select * from admin where adminName = ?";
        Admin admin = null;
        try {
            admin = new LPQueryRunner().query(DBCPUtil.getConnection(),
                    sql,
                    new BeanHandler<Admin>(Admin.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
}
