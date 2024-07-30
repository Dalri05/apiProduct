package com.API.first.controller;

import com.API.first.model.productModel;
import com.API.first.repository.productRepository;
import com.API.first.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class productController {

    private final ProductService service;
    private final productRepository repository;

    @Autowired
    public productController(ProductService service, productRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity getAllProducts(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<productModel> produtoPeloId(@PathVariable int id) {
        Optional<productModel> product = repository.findById(id);
        return ResponseEntity.ok(product.get());
    }

    @PostMapping
    public ResponseEntity<productModel> addProduto(@RequestBody productModel product) {
        productModel savedProduct = service.saveProduct(product);
        return ResponseEntity.ok(savedProduct);
    }
}
