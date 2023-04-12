package com.pieropan.consultacep.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CepDTO {

    @NotBlank(message = "CEP de preenchimento obrigatório")
    private String cep;
}