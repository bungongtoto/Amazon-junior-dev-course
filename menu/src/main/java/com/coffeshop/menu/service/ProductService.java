package com.coffeshop.menu.service;

import java.util.List;

import com.coffeshop.menu.model.Product;

public interface ProductService {

    List<Product> getAllProducts();

    void saveProduct(Product product);

    Product getProductById(int id);

    void deleteProductById(int id);
}
