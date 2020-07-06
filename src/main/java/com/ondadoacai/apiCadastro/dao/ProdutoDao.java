package com.ondadoacai.apiCadastro.dao;

import java.util.List;

import com.ondadoacai.apiCadastro.models.Produto;

//DATA ACESS OBJECT 
public interface ProdutoDao {
    void save(Produto produto);
    void update(Produto produto);
    void delete(Long id);
    Produto getProdutoId(Long id);
    List<Produto> getProdutos();
}