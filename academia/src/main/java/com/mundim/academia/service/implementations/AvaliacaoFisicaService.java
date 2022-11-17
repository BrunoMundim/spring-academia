package com.mundim.academia.service.implementations;

import com.mundim.academia.controller.AvaliacaoFisicaController;
import com.mundim.academia.model.Aluno;
import com.mundim.academia.model.AvaliacaoFisica;
import com.mundim.academia.model.forms.AvaliacaoFisicaForm;
import com.mundim.academia.repository.AlunoRepository;
import com.mundim.academia.repository.AvaliacaoFisicaRepository;
import com.mundim.academia.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoFisicaService implements IAvaliacaoFisicaService {

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    AvaliacaoFisicaRepository avaliacaoRepository;

    @Override
    public AvaliacaoFisica create(Integer id, AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();

        Aluno aluno = alunoRepository.findById(id).get();
        avaliacaoFisica.setAluno(aluno);

        avaliacaoFisica.setAltura(form.getAltura());
        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisica.setBodyFat(form.getBodyFat());
        avaliacaoFisica.setMassaMagra(form.getMassaMagra());

        return avaliacaoRepository.save(avaliacaoFisica);
    }

    @Override
    public List<AvaliacaoFisica> getAll(Integer id) {
        Aluno aluno = alunoRepository.findById(id).get();

        return avaliacaoRepository.findByAluno(aluno);
    }

    @Override
    public void delete(Integer idAvaliacao) {
        AvaliacaoFisica avaliacaoFisica = avaliacaoRepository.findById(idAvaliacao).get();
        avaliacaoRepository.delete(avaliacaoFisica);
    }
}
