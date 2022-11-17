package com.mundim.academia.model.forms;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AvaliacaoFisicaForm {

    @NotBlank(message = "Preencha os dados corretamente")
    private Double peso;

    @NotBlank(message = "Preencha os dados corretamente")
    private Double altura;

    @NotBlank(message = "Preencha os dados corretamente")
    private Double bodyFat;

    @NotBlank(message = "Preencha os dados corretamente")
    private Double massaMagra;

}
