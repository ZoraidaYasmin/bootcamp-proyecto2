package com.project2.springboot.user.app.services;

import com.project2.springboot.user.app.models.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
	
	public Flux<Product> findAll();
	
	public Mono<Product> findById(String id);
	
	public Mono<Product> save(Product product);
	
	public Mono<Product> update(Product product, String id);
	
	public Mono<Product> delete(String id);
}
