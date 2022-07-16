package com.project2.springboot.product.app.service;

import com.project2.springboot.product.app.entity.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

    Flux<Product> findAll();

    Mono<Product> create(Product c);

    Mono<Product> findById(String id);

    Mono<Product> update(Product c, String id);

    Mono<Product> delete(String id);
}
