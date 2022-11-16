package com.mundim.academia.service;

import com.mundim.academia.model.Aluno;
import com.mundim.academia.model.forms.AlunoForm;

import java.util.List;

public interface IAlunoService {

    Aluno create(AlunoForm alunoForm);

    Aluno get(Integer id);

    List<Aluno> getAll();

    Aluno update(Integer id, Aluno aluno);

    void delete(Integer id);

}
