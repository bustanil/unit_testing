package com.skyworx.shop.dao;

import com.skyworx.shop.model.Product;

import java.util.List;

public interface ProductDao {
    void save(Product product);

    Product get(Long productId);

    @SuppressWarnings("unchecked")
    List<Product> list();
}
