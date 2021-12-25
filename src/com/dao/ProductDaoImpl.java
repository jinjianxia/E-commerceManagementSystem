package com.dao;

import com.model.Product;
import com.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private DBUtil dbUtil = new DBUtil();

    @Override
    public List<Product> list() {
        String sql = "select * from products";
        Object[] objects = {};
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
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeAll();
        }
        return products;
    }
}
