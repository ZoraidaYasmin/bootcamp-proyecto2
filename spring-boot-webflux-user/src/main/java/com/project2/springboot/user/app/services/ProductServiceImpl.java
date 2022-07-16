package com.project2.springboot.user.app.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.project2.springboot.user.app.models.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private WebClient.Builder productWebClient;

	@Override
	public Flux<Product> findAll() {
		return productWebClient.build().get().uri("/findAll").retrieve().bodyToFlux(Product.class);
	}

	@Override
	public Mono<Product> findById(String id) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		return productWebClient.build().get().uri("/find/{id}", params)
				.retrieve()
				.bodyToMono(Product.class);
	}

	@Override
	public Mono<Product> save(Product product) {
		return productWebClient.build().post().uri("/create").bodyValue(product)
				.retrieve()
				.bodyToMono(Product.class);
	}
	
	@Override
	public Mono<Product> update(Product product, String id) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		return productWebClient.build().put().uri("/update/{id}", params).bodyValue(product)
				.retrieve()
				.bodyToMono(Product.class);
	}

	@Override
	public Mono<Product> delete(String id) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		return productWebClient.build().delete().uri("/delete/{id}", params)
				.exchangeToMono(response -> {
			         if (response.statusCode().equals(HttpStatus.OK)) {
			             return response.bodyToMono(Product.class);
			         }
			         else {
			             return response.createException().flatMap(Mono::error);
			         }
				});
		}
}
