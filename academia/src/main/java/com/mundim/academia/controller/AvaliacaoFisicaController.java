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
    public ResponseEntity<AvaliacaoFisica> create(@PathVariable("idAluno") Integer idAluno, @RequestBody AvaliacaoFisicaForm form){
        AvaliacaoFisica avaliacao = avaliacaoFisicaService.create(idAluno, form);

        if(avaliacao == null) {
            return new ResponseEntity<AvaliacaoFisica>((AvaliacaoFisica) null, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<AvaliacaoFisica>(avaliacao, HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/{idAvaliacao}")
    public ResponseEntity<AvaliacaoFisica> delete(@PathVariable("idAvaliacao") Integer id) {
        AvaliacaoFisica avaliacao = avaliacaoFisicaService.delete(id).orElse(null);

        if(avaliacao == null){
            return new ResponseEntity("Essa avaliacao nao existe!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AvaliacaoFisica>(avaliacao, HttpStatus.OK);
    }

}
