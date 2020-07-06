package com.ondadoacai.apiCadastro.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.ondadoacai.apiCadastro.models.Mensagem;
import com.ondadoacai.apiCadastro.models.Vendas;

import org.springframework.beans.factory.annotation.Autowired;

public class VendasDaoImplement implements VendasDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public void save(Vendas vendas) {
        entityManager.persist(vendas);

    }

    @Override
    public void update(Vendas vendas) {
        entityManager.merge(vendas);

    }

    @Override
    public void delete(long id) {
        entityManager.remove(entityManager.find(Mensagem.class, id));

    }

    @Override
    public List<Vendas> getVendas() {
        List<Vendas> lista = entityManager.createQuery("select v from Vendas v", Vendas.class).getResultList();
        return lista;
    }

    @Override
    public Vendas getVendaId(int id) {
        Vendas venda = entityManager.find(Vendas.class, id);
        return venda;
    }
    
}