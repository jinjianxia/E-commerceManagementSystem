package com.test;

import com.dao.ProductDao;
import com.dao.ProductDaoImpl;
import com.model.Page;
import com.model.Product;
import com.model.Provider;
import com.service.ProductService;
import com.service.ProductServiceImpl;
import com.service.ProviderService;
import com.service.ProviderServiceImpl;

import java.util.List;

public class TestProduct {
    public static void main(String[] args) {
//        ProductService productService = new ProductServiceImpl();
//        List<Product> products = productService.list();
//        测试dao
//        ProductDao productDao = new ProductDaoImpl();
//        int res = productDao.addProduct(new Product("薯片",1,1,1.0,2.0,10));
//        System.out.println("res = " + res);
//        System.out.println(productDao.getTotal());
//        List<Product> products = productDao.list();
//        List<Product> products = productDao.list(new Page(1, 20));
//        for (Product product : products) {
//            System.out.println(product);
//        }
        ProviderService providerService = new ProviderServiceImpl();
        List<Provider> providers = providerService.list(new Page(1,2));
        for (Provider provider : providers) {
            System.out.println(provider.getProviderName());
        }
    }
}
