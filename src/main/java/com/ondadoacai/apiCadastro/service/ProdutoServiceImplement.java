package com.ondadoacai.apiCadastro.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.ondadoacai.apiCadastro.models.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//ESTA CLASSE É UM REPOSITORIO
@Repository
public class ProdutoServiceImplement implements ProdutoService {
    // INJETANDO O ENTITYMANAGER (CRUD - JPA)
    @Autowired
    EntityManager entityManager;

    // SALVANDO O PRODUTO
    @Override
    public void save(Produto produto) {
        entityManager.persist(produto);

    }

    // ATUALIZANDO O PRODUTO
    @Override
    public void update(Produto produto) {
        entityManager.merge(produto);

    }

    //DELETANDO O PRODUTO
    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.find(Produto.class, id));
    }

    // RETORNA PRODUTO POR ID
    @Override
    public Produto getProdutoId(Long id) {
        Produto produto = entityManager.find(Produto.class, id);
        return produto;
    }

    // RETORNA TODOS OS PRODUTOS
    @Override
    public List<Produto> getProdutos() {
        List<Produto> lista = entityManager.createQuery("select p from Produto p", Produto.class)
        .getResultList();
        return lista;
    }
    
}