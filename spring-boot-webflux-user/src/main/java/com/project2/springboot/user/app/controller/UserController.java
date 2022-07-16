package com.project2.springboot.user.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project2.springboot.user.app.models.Product;
import com.project2.springboot.user.app.services.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private static final Logger log = LogManager.getLogger(UserController.class);
    
	@Autowired
    private ProductService productService;

    @GetMapping("/findAll")
    public Flux<Product> getProducts(){
        log.info("Service call FindAll - product");
        return productService.findAll();
    }

    @GetMapping("/find/{id}")
    public Mono<Product> getProduct(@PathVariable String id){
        log.info("Service call FindById - product");
        Mono<Product> newCustomer = productService.findById(id);
        return newCustomer;
    }

    @PostMapping("/save")
    public Mono<Product> createProduct(@RequestBody Product p){
        log.info("Service call create - product");
        return productService.save(p);
    }

    @PutMapping("/update/{id}")
    public Mono<Product> updateCustomer(@RequestBody Product p, @PathVariable String id){
        log.info("Service call Update - product");
        return productService.update(p,id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Product> deleteCustomer(@PathVariable String id){
        log.info("Service call delete - Product");
        return productService.delete(id);
    }
}
