package com.accenture.consumo.controller;

import com.accenture.consumo.repository.EnderecoRepository;
import com.accenture.consumo.service.CepService;
import com.accenture.consumo.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CepRestController {

    @Autowired
    private CepService cepService;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping("/{cep}")
    public ResponseEntity<Endereco> getCep(@PathVariable String cep) {
        Endereco endereco = cepService.buscaEnderecoPorCep(cep);

        if (endereco != null) {
            enderecoRepository.save(endereco);
            return ResponseEntity.ok().body(endereco);
        }

        return ResponseEntity.notFound().build();
    }
}

