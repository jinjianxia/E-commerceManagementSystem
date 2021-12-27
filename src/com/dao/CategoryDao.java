package com.dao;

import com.model.Category;
import com.model.Page;

import java.util.List;

public interface CategoryDao {
    List<Category> list();

    List<Category> list(Page page);
}
