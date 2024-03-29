package com.dao.impl;

import com.dao.CategoryDao;
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

    @Override
    public int delete(Category category) {
        int result = 0;
        String sql = "delete from categories where category_id=?";
        Object[] objects = {category.getCategoryId()};
        try {
            result = dbUtil.executeUpdate(sql, objects);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeAll();
        }
        return result;
    }

    @Override
    public int getTotal() {
        int total = 0;
        String sql = "select count(*) as total from categories";
        Object[] objects = {};
        ResultSet rs = dbUtil.executeQuery(sql, objects);
        try {
            rs.next();
            total = rs.getInt("total");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeAll();
        }
        return total;
    }

    @Override
    public int addCategory(Category category) {
        int result = 0;
        String sql = "insert into categories (category_name,category_desc) values (?, ?)";
        Object[] objects = {category.getCategoryName(), category.getCategoryDesc()};
        try {
            result = dbUtil.executeUpdate(sql, objects);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeAll();
        }
        return result;
    }

    @Override
    public int updateCategory(Category category) {
        int result = 0;
        String sql = "update categories set category_name = ?, category_desc = ? where category_id = ?";
        Object[] objects = {category.getCategoryName(), category.getCategoryDesc(), category.getCategoryId()};
        try {
            result = dbUtil.executeUpdate(sql, objects);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeAll();
        }
        return result;
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
