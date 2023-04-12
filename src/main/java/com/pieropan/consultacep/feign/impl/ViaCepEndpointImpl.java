package com.pieropan.consultacep.feign.impl;

import com.pieropan.consultacep.dto.CepDTO;
import com.pieropan.consultacep.dto.RetornoConsultaDTO;
import com.pieropan.consultacep.enums.RegiaoEnum;
import com.pieropan.consultacep.feign.ViaCepEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;

@Service
public class ViaCepEndpointImpl {

    @Autowired
    ViaCepEndpoint viaCepEndpoint;

    public RetornoConsultaDTO obterCep(CepDTO dto) throws IllegalArgumentException {

        RetornoConsultaDTO consulta = viaCepEndpoint.obterCep(dto.getCep());
        if (Objects.isNull(consulta.getCep())) {
            throw new IllegalArgumentException();
        }

        String estado = consulta.getUf().toUpperCase();
        consulta.setFrete(RegiaoEnum.getRegiaoEnum(estado).valorFrete());
        return consulta;
    }
}