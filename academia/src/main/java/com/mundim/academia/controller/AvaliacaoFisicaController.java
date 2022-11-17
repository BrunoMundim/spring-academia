package com.mundim.academia.controller;

import com.mundim.academia.model.AvaliacaoFisica;
import com.mundim.academia.model.forms.AvaliacaoFisicaForm;
import com.mundim.academia.service.implementations.AvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos/avaliacoes/")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaService avaliacaoFisicaService;

    @GetMapping("/{idAluno}")
    public List<AvaliacaoFisica> getAll(@PathVariable("idAluno") Integer idAluno){
        return avaliacaoFisicaService.getAll(idAluno);
    }

    @PostMapping("/{idAluno}")
    public AvaliacaoFisica create(@PathVariable("idAluno") Integer idAluno, @RequestBody AvaliacaoFisicaForm form){
        return avaliacaoFisicaService.create(idAluno, form);
    }

    @DeleteMapping("/{idAvaliacao}")
    public ResponseEntity delete(@PathVariable("idAvaliacao") Integer id) {
        avaliacaoFisicaService.delete(id);
        return new ResponseEntity("Avaliação apagada!", HttpStatus.OK);
    }

}
