package com.mundim.academia.repository;

import com.mundim.academia.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    Aluno findByNome(String nome);

    Aluno findByCPF(String cpf);

    List<Aluno> findByNomeContaining(String nome);
}
