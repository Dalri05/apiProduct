package com.API.first.service;

import com.API.first.model.VendasModel;
import com.API.first.repository.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendasService {

    private final VendasRepository repository;

    @Autowired
    public VendasService(VendasRepository repository) {
        this.repository = repository;
    }

    public VendasModel saveVenda(VendasModel cliente) {
        return repository.save(cliente);
    }
}
