package com.mundim.academia.service;

import com.mundim.academia.model.AvaliacaoFisica;
import com.mundim.academia.model.forms.AvaliacaoFisicaForm;

import java.util.List;
import java.util.Optional;

public interface IAvaliacaoFisicaService {

    AvaliacaoFisica create(Integer id, AvaliacaoFisicaForm form);

    List<AvaliacaoFisica> getAll(Integer id);

    Optional<AvaliacaoFisica> delete(Integer idAvaliacao);

}
