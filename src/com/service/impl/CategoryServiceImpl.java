package com.service.impl;

import com.dao.CategoryDao;
import com.dao.impl.CategoryDaoImpl;
import com.model.Category;
import com.model.Page;
import com.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> list() {
        return categoryDao.list();
    }

    @Override
    public List<Category> list(Page page) {
        return categoryDao.list(page);
    }

    @Override
    public int delete(Category category) {
        return categoryDao.delete(category);
    }

    @Override
    public int getTotal() {
        return categoryDao.getTotal();
    }

    @Override
    public int addCategory(Category category) {
        return categoryDao.addCategory(category);
    }

    @Override
    public int updateCategory(Category category) {
        return categoryDao.updateCategory(category);
    }
}
