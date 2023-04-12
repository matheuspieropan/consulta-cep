package com.pieropan.consultacep.controller;

import com.pieropan.consultacep.dto.CepDTO;
import com.pieropan.consultacep.feign.impl.ViaCepEndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ws")
public class CepController {

    @Autowired
    ViaCepEndpointImpl viaCepEndpointImpl;

    @PostMapping("/consulta-endereco")
    public ResponseEntity obterCep(@RequestBody @Validated CepDTO cep) throws IllegalArgumentException {

        return ResponseEntity.ok(viaCepEndpointImpl.obterCep(cep));
    }
}