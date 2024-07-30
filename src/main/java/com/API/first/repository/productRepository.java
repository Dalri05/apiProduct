package com.API.first.repository;

import com.API.first.model.productModel;
import com.API.first.service.ProductService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface productRepository extends JpaRepository<productModel, Integer> {
}
