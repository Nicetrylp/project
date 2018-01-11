package com.nicetry.bookstore.category.admin.service;

import com.nicetry.bookstore.category.admin.service.exception.InsertException;
import com.nicetry.bookstore.category.dao.CategoryDao;
import com.nicetry.bookstore.category.domain.Category;

import java.util.List;

public class AdminCategoryService {
    CategoryDao categoryDao = new CategoryDao();
    public List<Category> queryAll() {
        List<Category> categories = categoryDao.queryAll();
        return categories;
    }

    public void addCategory(Category category) throws InsertException {
        Category category1 = categoryDao.queryByCategory(category.getCname());
        if (category1 != null){
            throw new InsertException();
        }
        categoryDao.insertCategory(category);
    }

    public void molCategory(String cid, String cname) {
        if (cname == null || cname.equals("")){
            //TODO 异常,
        }
        categoryDao.updateCategory(cid,cname);
    }

    public void delCategory(String cid) {
        categoryDao.removeCategoryById(cid);
    }

}
