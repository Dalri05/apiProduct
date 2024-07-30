package com.API.first.service;

import com.API.first.model.productModel;
import com.API.first.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final productRepository repository;

    @Autowired
    public ProductService(productRepository repository) {
        this.repository = repository;
    }

    public productModel saveProduct(productModel product) {
        return repository.save(product);
    }

    public Optional<productModel> getProductById(int id) {
        return repository.findById(id);
    }
}
