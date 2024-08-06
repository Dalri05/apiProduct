package com.API.first.controller;

import com.API.first.enums.ClienteEnum;
import com.API.first.model.ClienteModel;
import com.API.first.repository.ClienteRepository;
import com.API.first.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @PutMapping("/transformarCliente/{id}")
    public ResponseEntity transformarCliente(@PathVariable int id, @RequestBody ClienteEnum tipoCliente) throws Exception {
        try {
            String mensagemFinal;
            Optional<ClienteModel> clienteNovaSituacao = service.getClienteById(id);
            if (clienteNovaSituacao.isPresent()) {
                mensagemFinal = "Cliente Atualizado com sucesso";
                ClienteModel cliente = clienteNovaSituacao.get();
                cliente.setSituacao(tipoCliente);
                repository.save(cliente);
                return ResponseEntity.ok(mensagemFinal);
            }
            mensagemFinal = "Erro ao atualizar situacao do cliente";
            return ResponseEntity.ok(mensagemFinal);

        } catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        }
    }

    @PostMapping("/novoCliente")
    public ResponseEntity novoCliente(@RequestBody ClienteModel cliente){
        ClienteModel saveCliente = service.saveCliente(cliente);
        return ResponseEntity.ok(saveCliente);
    }

}
