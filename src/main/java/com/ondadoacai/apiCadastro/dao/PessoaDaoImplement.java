package com.ondadoacai.apiCadastro.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.ondadoacai.apiCadastro.models.Pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PessoaDaoImplement implements PessoaDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void save(Pessoa pessoa) {
        entityManager.persist(pessoa);

    }

    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.find(Pessoa.class, id));

    }

    @Override
    public void update(Pessoa pessoa) {
        entityManager.merge(pessoa);

    }

    @Override
    public Pessoa getPessoaId(Long id) {
        Pessoa p = entityManager.find(Pessoa.class, id);
        return p;
    }

    @Override
    public List<Pessoa> getPessoa() {
        List<Pessoa> p = entityManager.createQuery("Select p from Pessoa p", Pessoa.class).getResultList();
        return p;
    }
    
}