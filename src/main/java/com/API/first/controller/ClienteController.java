package com.API.first.controller;

import com.API.first.model.ClienteModel;
import com.API.first.repository.ClienteRepository;
import com.API.first.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteService service;
    private final ClienteRepository repository;
    @Autowired
    public ClienteController(ClienteService service, ClienteRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping("/getClientes")
    public ResponseEntity PegarTodosClientes(){
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity novoCliente(@RequestBody ClienteModel cliente){
        ClienteModel saveCliente = service.saveCliente(cliente);
        return ResponseEntity.ok(saveCliente);
    }

}
