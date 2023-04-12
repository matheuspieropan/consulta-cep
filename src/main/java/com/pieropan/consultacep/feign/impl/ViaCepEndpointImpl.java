package com.pieropan.consultacep.feign.impl;

import com.pieropan.consultacep.dto.RetornoConsultaDTO;
import com.pieropan.consultacep.enums.RegiaoEnum;
import com.pieropan.consultacep.feign.ViaCepEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViaCepEndpointImpl {

    @Autowired
    ViaCepEndpoint feignClient;

    public RetornoConsultaDTO getCep(String cep) {

        RetornoConsultaDTO dto = feignClient.getCep(cep);
        dto.setFrete(RegiaoEnum.getRegiaoEnum(dto.getUf().toUpperCase()).valorFrete());
        return dto;
    }
}