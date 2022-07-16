package com.project2.springboot.product.app.controller;

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

import com.project2.springboot.product.app.entity.Product;
import com.project2.springboot.product.app.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductController {

    private static final Logger log = LogManager.getLogger(ProductController.class);
    @Autowired
    private ProductService productService;

    @GetMapping("/findAll")
    public Flux<Product> getCustomers(){
        log.info("Service call FindAll - product");
        return productService.findAll();
    }

    @GetMapping("/find/{id}")
    public Mono<Product> getCustomer(@PathVariable String id){
        log.info("Service call FindById - product");
        Mono<Product> newCustomer = productService.findById(id);
        return newCustomer;
    }

    @PostMapping("/create")
    public Mono<Product> createCustomer(@RequestBody Product p){
        log.info("Service call create - product");
        return productService.create(p);
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
