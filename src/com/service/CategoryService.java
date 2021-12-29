package com.service;

import com.model.Category;
import com.model.Page;

import java.util.List;

public interface CategoryService {
    List<Category> list();

    List<Category> list(Page page);

    int delete(Category category);

    int getTotal();

    int addCategory(Category category);

    int updateCategory(Category category);
}
