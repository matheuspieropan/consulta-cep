package com.pieropan.consultacep.controller;

import com.pieropan.consultacep.feign.impl.ViaCepEndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ws")
public class CepController {

    @Autowired
    ViaCepEndpointImpl viaCepEndpointImpl;

    @GetMapping("/{cep}")
    public ResponseEntity getCep(@PathVariable String cep) {

        return ResponseEntity.ok(viaCepEndpointImpl.getCep(cep));
    }
}