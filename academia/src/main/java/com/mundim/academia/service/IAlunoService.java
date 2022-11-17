package com.mundim.academia.service;

import com.mundim.academia.model.Aluno;
import com.mundim.academia.model.forms.AlunoForm;
import com.mundim.academia.model.forms.AlunoUpdateForm;

import java.util.List;

public interface IAlunoService {

    Aluno create(AlunoForm alunoForm);

    Aluno get(Integer id);

    List<Aluno> getAll();

    Aluno update(Integer id, AlunoUpdateForm alunoUpdateForm);

    void delete(Integer id);

    List<Aluno> getByNome(String nome);

    Aluno getByCPF(String cpf);

}
