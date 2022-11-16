package com.mundim.academia.controller;

import com.mundim.academia.model.Aluno;
import com.mundim.academia.model.forms.AlunoForm;
import com.mundim.academia.service.implementations.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> getAll(){
        return alunoService.getAll();
    }

    @GetMapping("/{id}")
    public Aluno getAlunoById(@RequestParam Integer id){
        return alunoService.get(id);
    }

    @PostMapping
    public Aluno create(@Valid @RequestBody AlunoForm form){
        return alunoService.create(form);
    }

    @PostMapping("/{id}")
    public Aluno update(@RequestParam Integer id, @Valid @RequestBody Aluno aluno){
        return alunoService.update(id, aluno);
    }

}
