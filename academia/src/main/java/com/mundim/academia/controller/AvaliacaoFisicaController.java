package com.mundim.academia.controller;

import com.mundim.academia.model.AvaliacaoFisica;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alunos/avaliacoes/")
public class AvaliacaoFisicaController {

    @GetMapping("/{id}")
    public List<AvaliacaoFisica> getAll(@PathVariable("id") Integer id){

    }

}
