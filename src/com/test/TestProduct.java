package com.test;

import com.model.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

import java.util.List;

public class TestProduct {
    public static void main(String[] args) {
        ProductService productService = new ProductServiceImpl();
        List<Product> products = productService.list();
        for (Product product : products) {
            System.out.println(product);
        }
//        测试dao
//        ProductDao productDao = new ProductDaoImpl();
//        List<Product> products = productDao.list();
//        for (Product product : products) {
//            System.out.println(product);
//        }


    }
}
