package com.dao.impl;

import com.dao.ProductDao;
import com.model.Page;
import com.model.Product;
import com.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private final DBUtil dbUtil = new DBUtil();

    @Override
    public List<Product> list() {
        String sql = "select a.*,b.category_name, c.provider_name from products a, categories b, providers c where a.category_id = b.category_id and a.provider_id = c.provider_id";
        Object[] objects = {};
        return getProducts(sql, objects);
    }

    @Override
    public List<Product> list(Page page) {
        String sql = "select a.*,b.category_name, c.provider_name from products a, categories b, providers c where a.category_id = b.category_id and a.provider_id = c.provider_id limit ?,?";
        Object[] objects = {(page.getPageNum() - 1) * page.getSize(), page.getSize()};
        return getProducts(sql, objects);
    }

    private List<Product> getProducts(String sql, Object[] objects) {
        List<Product> products = new ArrayList<>();
        try {
            ResultSet rs = dbUtil.executeQuery(sql, objects);
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setPurchasePrice(rs.getDouble("purchase_price"));
                product.setSalesPrice(rs.getDouble("sales_price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setCategoryId(rs.getInt("category_id"));
                product.setProviderId(rs.getInt("provider_id"));
                product.setCategoryName(rs.getString("category_name"));
                product.setProviderName(rs.getString("provider_name"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeAll();
        }
        return products;
    }

    @Override
    public int delete(Product product) {
        int result = 0;
        String sql = "delete from products where product_id=?";
        Object[] objects = {product.getProductId()};
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
        String sql = "select count(*) as total from products a, categories b, providers c where a.category_id = b.category_id and a.provider_id = c.provider_id";
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
    public int addProduct(Product product) {
        int result = 0;
        String sql = "insert into products (product_name, category_id, provider_id, quantity, purchase_price, sales_price, created_time) values (?, ?, ?, ?, ?, ?, ?)";
        Object[] objects = {product.getProductName(), product.getCategoryId(), product.getProviderId(), product.getQuantity(), product.getPurchasePrice(), product.getSalesPrice(), new Date()};
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
    public int updateProduct(Product product) {
        int result = 0;
        String sql = "update products set product_name = ?, quantity = ?, purchase_price = ?, sales_price = ?, category_id = ?, provider_id = ? where product_id = ?";
        Object[] objects = {product.getProductName(), product.getQuantity(), product.getPurchasePrice(), product.getSalesPrice(), product.getCategoryId(), product.getProviderId(), product.getProductId()};
        try {
            result = dbUtil.executeUpdate(sql, objects);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeAll();
        }
        return result;
    }
}
