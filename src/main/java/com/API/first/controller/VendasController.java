package com.API.first.controller;

import com.API.first.model.VendasModel;
import com.API.first.repository.VendasRepository;
import com.API.first.service.VendasService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Getter
@Setter
@RequestMapping("/vendas")
public class VendasController {
    private final VendasService service;
    private final VendasRepository repository;

    @Autowired
    public VendasController(VendasService service, VendasRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity verVendas(){
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/novaVenda")
    public ResponseEntity registrarVenda(@RequestBody VendasModel venda){
        venda = service.saveVenda(venda);
        return ResponseEntity.ok(venda);
    }
}
