package com.API.first.service;

import com.API.first.model.ClienteModel;
import com.API.first.model.productModel;
import com.API.first.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ClienteService {

    private final ClienteRepository repository;

    @Autowired
    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public ClienteModel saveCliente(ClienteModel cliente) {
        return repository.save(cliente);
    }

    public Optional<ClienteModel> getClienteById(int id) {
        return repository.findById(id);
    }
}
