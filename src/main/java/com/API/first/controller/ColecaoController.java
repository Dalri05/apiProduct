package com.API.first.controller;

import com.API.first.model.ColecaoModel;
import com.API.first.repository.ColecaoRepository;
import com.API.first.service.ColecaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/colecao")
public class ColecaoController {
    private final ColecaoRepository colecaoRepository;
    private final ColecaoService colecaoService;

    @Autowired
    public ColecaoController(ColecaoRepository colecaoRepository, ColecaoService colecaoService) {
        this.colecaoRepository = colecaoRepository;
        this.colecaoService = colecaoService;
    }
}
