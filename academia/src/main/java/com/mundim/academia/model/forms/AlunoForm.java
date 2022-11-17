package com.mundim.academia.model.forms;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoForm {

    @NotBlank(message = "Preencha os dados corretamente")
    @Size(min = 3, max = 100, message = "'${validatedValue}' precisa ter entre {min} e {max} caracteres.")
    private String nome;

    @NotBlank(message = "Preencha os dados corretamente")
    @CPF(message = "'${validatedValue}' é um CPF inválido.")
    private String cpf;

    @NotNull(message = "Preencha os dados corretamente")
    @Past(message = "Data '${validatedValue}' é inválida")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private String genero;

}
