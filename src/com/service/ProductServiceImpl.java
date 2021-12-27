package com.service;

import com.dao.ProductDao;
import com.dao.ProductDaoImpl;
import com.model.Page;
import com.model.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao = new ProductDaoImpl();

    @Override
    public List<Product> list() {
        return productDao.list();
    }

    @Override
    public List<Product> list(Page page) {
        return productDao.list(page);
    }

    @Override
    public int delete(Product product) {
        return productDao.delete(product);
    }

    @Override
    public int getTotal() {
        return productDao.getTotal();
    }

    @Override
    public int addProduct(Product product) {
        return productDao.addProduct(product);
    }
}
