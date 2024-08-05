package com.API.first.controller;

import com.API.first.enums.ClienteEnum;
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

    @GetMapping("/getclientes")
    public ResponseEntity pegarTodosClientes(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/clientesInativos")
    public ResponseEntity buscarClientesInativos(){
        return ResponseEntity.ok(repository.buscarClientesInativo(ClienteEnum.INATIVO));
    }

    @PostMapping("/novoCliente")
    public ResponseEntity novoCliente(@RequestBody ClienteModel cliente){
        ClienteModel saveCliente = service.saveCliente(cliente);
        return ResponseEntity.ok(saveCliente);
    }

}
