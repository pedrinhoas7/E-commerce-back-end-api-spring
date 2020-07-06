package com.ondadoacai.apiCadastro.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.ondadoacai.apiCadastro.models.Mensagem;


import org.springframework.beans.factory.annotation.Autowired;

public class MensagemDaoImplement implements MensagemDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public void save(Mensagem mensagem) {
        entityManager.persist(mensagem);

    }

    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.find(Mensagem.class, id));

    }

    @Override
    public void update(Mensagem mensagem) {
        entityManager.merge(mensagem);

    }

    @Override
    public Mensagem getMensagemId(Long id) {
        Mensagem msg = entityManager.find(Mensagem.class, id);
        return msg;
    }

    @Override
    public List<Mensagem> getMensagens() {
       List<Mensagem> mensagems = entityManager.createQuery("select m from MENSAGEM m", Mensagem.class).getResultList();
        return mensagems;
    }
    
}