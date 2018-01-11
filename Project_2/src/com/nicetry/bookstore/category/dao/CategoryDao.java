package com.nicetry.bookstore.category.dao;


import com.nicetry.bookstore.category.domain.Category;
import com.nicetry.bookstore.util.DBCPUtil;
import com.nicetry.bookstore.util.LPQueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDao {
    public List<Category> queryAll(){
        String sql = "select * from category";
        List<Category> categories = null;
        try {
            categories = new LPQueryRunner().query(DBCPUtil.getConnection(),
                    sql,
                    new BeanListHandler<Category>(Category.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public Category queryByCategory(String category){
        String sql = "select * from category where cname = ?";
        Category category1 = null;
        try {
            category1 = new LPQueryRunner().query(DBCPUtil.getConnection(),
                    sql,
                    new BeanHandler<Category>(Category.class)
                    ,category);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category1;
    }

    public void insertCategory(Category cname) {
        String sql = "insert into category values(?,?)";
        try {
            new LPQueryRunner().update(DBCPUtil.getConnection(),
                    sql,
                    cname.getCid(), cname.getCname());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCategory(String cid, String cname) {
        String sql = "update category set cname = ? where cid = ?";
        try {
            new LPQueryRunner().update(DBCPUtil.getConnection(),
                    sql,
                    cname,cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeCategoryById(String cid) {
        String sql = "delete from category where cid = ?";
        try {
            new LPQueryRunner().update(DBCPUtil.getConnection(),
                    sql,
                    cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
