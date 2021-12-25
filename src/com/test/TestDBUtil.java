package com.test;

import com.model.Product;
import com.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDBUtil {
    public static void main(String[] args) {
        DBUtil dbUtil = new DBUtil();
        String sql = "select * from products where product_name = ?";
        Object[] objects = {"营养快线"};
        List<Product> products = new ArrayList<>();
        try {
            ResultSet rs = dbUtil.executeQuery(sql, objects);
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                products.add(product);
            }
            System.out.println(products);
            System.out.println("successful operation");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeAll();
        }
    }
}
