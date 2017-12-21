package com.lanou3g.study;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class WHQueryRunner extends QueryRunner{
    @Override
    public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh) throws SQLException {
        // 开启事物
        conn.setAutoCommit(false);
        T t = super.query(conn,sql,rsh);
        // 提交事物
        conn.commit();
        conn.close();
        return t;
    }

    @Override
    public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        // 开启事物
        conn.setAutoCommit(false);
        T t = super.query(conn, sql, rsh, params);
        // 提交事物
        conn.commit();
        conn.close();
        return t;
    }
}
