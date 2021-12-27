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
}
