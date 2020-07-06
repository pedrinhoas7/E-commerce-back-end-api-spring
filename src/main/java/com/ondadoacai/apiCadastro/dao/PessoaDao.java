package com.ondadoacai.apiCadastro.dao;

import java.util.List;

import com.ondadoacai.apiCadastro.models.Pessoa;

public interface PessoaDao {
    void save(Pessoa pessoa);
    void delete(Long id);
    void update(Pessoa pessoa);
    Pessoa getPessoaId(Long id);
    List<Pessoa> getPessoa();
}