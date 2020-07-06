package com.ondadoacai.apiCadastro.service;

import java.util.List;

import com.ondadoacai.apiCadastro.models.Produto;

//INTERFACE DE SERVIÇO
public interface ProdutoService {
    void save(Produto produto);
    void update(Produto produto);
    void delete(Long id);
    Produto getProdutoId(Long id);
    List<Produto> getProdutos();
}