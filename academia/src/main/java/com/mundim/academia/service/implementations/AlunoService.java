package com.mundim.academia.service.implementations;

import com.mundim.academia.model.Aluno;
import com.mundim.academia.model.forms.AlunoForm;
import com.mundim.academia.repository.AlunoRepository;
import com.mundim.academia.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlunoService implements IAlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    @Override
    public Aluno create(AlunoForm alunoForm) {
        Aluno aluno = new Aluno();

        aluno.setNome(alunoForm.getNome());
        aluno.setCPF(alunoForm.getCpf());
        aluno.setDataNascimento(alunoForm.getDataNascimento());
        aluno.setGenero(alunoForm.getGenero());
        aluno.setDataMatricula(LocalDate.now());

        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno get(Integer id) {
        return alunoRepository.findById(id).get();
    }

    @Override
    public List<Aluno> getAll() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno update(Integer id, Aluno aluno) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
