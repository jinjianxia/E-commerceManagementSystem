package com.service;

import com.model.Page;
import com.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> list();

    List<Product> list(Page page);

    int delete(Product product);

    int getTotal();

    int addProduct(Product product);
}
