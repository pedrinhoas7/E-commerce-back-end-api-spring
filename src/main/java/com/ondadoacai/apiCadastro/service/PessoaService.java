package com.ondadoacai.apiCadastro.service;

import java.util.List;

import com.ondadoacai.apiCadastro.models.Pessoa;

public interface PessoaService {
    void save(Pessoa pessoa);
    void delete(Long id);
    void update(Pessoa pessoa);
    Pessoa getPessoaId(Long id);
    List<Pessoa> getPessoa();
}