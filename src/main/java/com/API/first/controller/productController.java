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
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<productModel> addProduto(@RequestBody productModel product) {
        productModel savedProduct = service.saveProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<productModel> deleteProduct(@PathVariable int id) {
        Optional<productModel> product = repository.findById(id);
        if (product.isPresent()) {
            repository.deleteById(id);
        } else {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product.get());
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<productModel> updateProduct(@PathVariable int id, @RequestBody productModel product) {
        Optional<productModel> produtoParaEditar = service.getProductById(id);

        if (produtoParaEditar.isPresent()) {
            productModel produtoExistente = produtoParaEditar.get();
            if (product.getName() != null) produtoExistente.setName(product.getName());
            if (product.getDescription() != null) produtoExistente.setDescription(product.getDescription());

            service.saveProduct(produtoExistente);
            return ResponseEntity.ok(produtoExistente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
