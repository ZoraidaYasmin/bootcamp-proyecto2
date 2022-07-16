package com.project2.springboot.product.app.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.project2.springboot.product.app.entity.Product;

public interface ProductRepository extends ReactiveCrudRepository<Product, String> {
}
