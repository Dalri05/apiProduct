package com.API.first.controller;

import com.API.first.enums.ClienteEnum;
import com.API.first.model.ClienteModel;
import com.API.first.model.VendasModel;
import com.API.first.repository.VendasRepository;
import com.API.first.service.ClienteService;
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
    private final ClienteService clienteService;

    @Autowired
    public VendasController(VendasService service, VendasRepository repository, ClienteService clienteService) {
        this.service = service;
        this.repository = repository;
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity verVendas(){
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/novaVenda")
    public ResponseEntity registrarVenda(@RequestBody VendasModel venda){
        ClienteModel cliente = venda.getCliente();
        try {
            if (cliente.getSituacao() == ClienteEnum.INATIVO){
                cliente.setSituacao(ClienteEnum.ATIVO);
                clienteService.saveCliente(cliente);
            }
            service.saveVenda(venda);
            return ResponseEntity.ok("Venda registrada com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao registrar venda: " + e.getMessage());
        }
    }
}
