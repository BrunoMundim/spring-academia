package com.mundim.academia.repository;

import com.mundim.academia.model.Aluno;
import com.mundim.academia.model.AvaliacaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisica, Integer> {

    public List<AvaliacaoFisica> findByAluno(Aluno aluno);

}
