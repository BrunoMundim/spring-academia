package com.mundim.academia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String CPF;

    private String nome;
    private LocalDate dataNascimento;
    private String genero;
    private LocalDate dataMatricula;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tb_aluno_roles", joinColumns = @JoinColumn(name = "nome_id"))
    @Column(name = "role_id")
    private List<String> roles = new ArrayList<>();

}
