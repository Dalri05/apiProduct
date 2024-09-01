package com.API.first.service;

import com.API.first.repository.ColecaoRepository;
import com.API.first.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColecaoService {
    private final ColecaoRepository repository;

    @Autowired
    public ColecaoService(ColecaoRepository repository) {
        this.repository = repository;
    }
}
