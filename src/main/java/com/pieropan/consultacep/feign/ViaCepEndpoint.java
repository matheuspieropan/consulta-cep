package com.pieropan.consultacep.feign;

import com.pieropan.consultacep.dto.RetornoConsultaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "service-cep",  url = "https://viacep.com.br/")
public interface ViaCepEndpoint {

    @GetMapping(value = "/ws/{cep}/json")
    RetornoConsultaDTO getCep(@PathVariable String cep);
}