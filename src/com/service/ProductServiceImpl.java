package com.service;

import com.dao.ProductDao;
import com.dao.ProductDaoImpl;
import com.model.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao = new ProductDaoImpl();

    @Override
    public List<Product> list() {
        return productDao.list();
    }

    @Override
    public int delete(Product product) {
        return productDao.delete(product);
    }
}
