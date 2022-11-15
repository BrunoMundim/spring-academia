package com.mundim.academia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100, nullable = false)
    private String nome;
    @Column(length = 14, nullable = false, unique = true)
    private String CPF;
    private LocalDate dataNascimento;
    @Column(length = 1)
    private String genero;
    private LocalDate dataMatricula;

}
