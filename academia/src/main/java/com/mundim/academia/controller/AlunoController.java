package com.mundim.academia.controller;

import com.mundim.academia.model.Aluno;
import com.mundim.academia.model.forms.AlunoForm;
import com.mundim.academia.model.forms.AlunoUpdateForm;
import com.mundim.academia.service.implementations.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Aluno> getAlunoById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(alunoService.get(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Aluno>> getAlunoByNome(@PathVariable("nome") String nome) {
        return ResponseEntity.ok(alunoService.getByNome(nome));
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Aluno> getAlunoByCPF(@PathVariable("cpf") String cpf) {
        return ResponseEntity.ok(alunoService.getByCPF(cpf));
    }

    @PostMapping
    public Aluno create(@Valid @RequestBody AlunoForm form){
        return alunoService.create(form);
    }

    @PostMapping("/{id}")
    public Aluno update(@RequestParam Integer id, @Valid @RequestBody AlunoUpdateForm aluno){
        return alunoService.update(id, aluno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        Aluno aluno = alunoService.get(id);
        String nome = aluno.getNome();
        alunoService.delete(id);
        return new ResponseEntity("Aluno " + nome + " deletado!", HttpStatus.OK);
    }
}
