package com.ondadoacai.apiCadastro.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.ondadoacai.apiCadastro.models.Mensagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MensagemServiceImplement implements MensagemService {
    @Autowired
    private EntityManager entityManager;
    @Override
    public void save(Mensagem mensagem) {
        entityManager.persist(mensagem);

    }

    @Override
    public void delete(String id) {
        entityManager.remove(entityManager.find(Mensagem.class, id));

    }

    @Override
    public void update(Mensagem mensagem) {
        entityManager.merge(mensagem);

    }

    @Override
    public Mensagem getMensagemId(String id) {
        Mensagem msg = entityManager.find(Mensagem.class, id);
        return msg;
    }

    @Override
    public List<Mensagem> getMensagens() {
        List<Mensagem> lista = entityManager.createQuery("select m from Mensagem m", Mensagem.class).getResultList();
        return lista;
    }
    
}