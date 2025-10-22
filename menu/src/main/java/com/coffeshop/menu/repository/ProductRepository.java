package com.coffeshop.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffeshop.menu.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
