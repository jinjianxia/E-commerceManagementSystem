package com.test;

import com.dao.ProductDao;
import com.dao.ProductDaoImpl;
import com.model.Page;
import com.model.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

import java.util.List;

public class TestProduct {
    public static void main(String[] args) {
//        ProductService productService = new ProductServiceImpl();
//        List<Product> products = productService.list();
//        测试dao
        ProductDao productDao = new ProductDaoImpl();
//        List<Product> products = productDao.list();
        List<Product> products = productDao.list(new Page(2,2));
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
