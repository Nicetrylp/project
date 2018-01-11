package com.nicetry.bookstore.category.service;

import com.nicetry.bookstore.category.dao.CategoryDao;
import com.nicetry.bookstore.category.domain.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    CategoryDao categoryDao = new CategoryDao();
    public List<String> queryAll() {
        List<Category> categories = categoryDao.queryAll();
        List<String> list = new ArrayList<>();
        for (Category category : categories) {
            list.add(category.getCname());
        }
        return list;
    }
}
