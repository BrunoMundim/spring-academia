package com.mundim.academia.service.implementations;

import com.mundim.academia.model.Aluno;
import com.mundim.academia.model.forms.AlunoForm;
import com.mundim.academia.model.forms.AlunoUpdateForm;
import com.mundim.academia.repository.AlunoRepository;
import com.mundim.academia.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
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
    public List<Aluno> getAll() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno get(Integer id) {
        return alunoRepository.findById(id).get();
    }

    @Override
    public List<Aluno> getByNome(String nome) {
        return alunoRepository.findByNomeContaining(nome);
    }

    @Override
    public Aluno getByCPF(String cpf) {
        return alunoRepository.findByCPF(cpf);
    }

    @Override
    public Aluno update(Integer id, AlunoUpdateForm alunoUpdateForm) {
        Aluno aluno = new Aluno();
        Aluno oldAluno = alunoRepository.findById(id).get();

        aluno.setId(oldAluno.getId());
        aluno.setNome(alunoUpdateForm.getNome());
        aluno.setGenero(alunoUpdateForm.getGenero());
        aluno.setDataNascimento(alunoUpdateForm.getDataNascimento());
        aluno.setCPF(oldAluno.getCPF());
        aluno.setDataMatricula(oldAluno.getDataMatricula());

        aluno.setId(oldAluno.getId());

        return alunoRepository.save(aluno);
    }

    @Override
    public void delete(Integer id) {
        alunoRepository.deleteAllByIdInBatch(Collections.singleton(id));
    }


}
