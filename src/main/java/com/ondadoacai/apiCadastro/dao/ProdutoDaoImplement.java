package com.ondadoacai.apiCadastro.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.ondadoacai.apiCadastro.models.Produto;

import org.springframework.beans.factory.annotation.Autowired;

public class ProdutoDaoImplement implements ProdutoDao {

    // INJETANDO  ENTITYMANAGER (CRUD - JPA)
    @Autowired
    EntityManager entityManager;

    // SALVANDO PRODUTO
    @Override
    public void save(Produto produto) {
        entityManager.persist(produto);
    }

    // ATUALIZANDO O PRODUTO
    @Override
    public void update(Produto produto) {
        entityManager.merge(produto);
    }

    // DELETANDO O PRODUTO
    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.find(Produto.class, id));
    }

    // LISTANDO O PRODUTO
    @Override
    public Produto getProdutoId(Long id) {
        Produto produto = entityManager.find(Produto.class, id);
        return produto;
    }

    // LISTANDO TODOS PRODUTOS
    @Override
    public List<Produto> getProdutos() {
        List<Produto> lista = entityManager.createQuery("select * from Produto", Produto.class).getResultList();
        return lista;
    }
    
}