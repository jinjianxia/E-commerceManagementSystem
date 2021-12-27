package com.dao;

import com.model.Category;
import com.model.Page;
import com.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    private final DBUtil dbUtil = new DBUtil();

    @Override
    public List<Category> list() {
        String sql = "select * from categories";
        Object[] objects = {};
        return getCategory(sql, objects);
    }

    @Override
    public List<Category> list(Page page) {
        String sql = "select * from categories limit ?, ?";
        Object[] objects = {(page.getPageNum() - 1) * page.getSize(), page.getSize()};
        return getCategory(sql, objects);
    }

    private List<Category> getCategory(String sql, Object[] objects) {
        List<Category> categories = new ArrayList<>();
        try {
            ResultSet rs = dbUtil.executeQuery(sql, objects);
            while (rs.next()) {
                Category category = new Category();
                category.setCategoryId(rs.getInt("category_id"));
                category.setCategoryName(rs.getString("category_name"));
                category.setCategoryDesc(rs.getString("category_desc"));
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeAll();
        }
        return categories;
    }
}
