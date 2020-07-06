package com.ondadoacai.apiCadastro.dao;

import java.util.List;

import com.ondadoacai.apiCadastro.models.Vendas;

public interface VendasDao {
    void save(Vendas vendas);
    void update(Vendas vendas);
    void delete(long id);
    List<Vendas> getVendas();
    Vendas getVendaId(int id);

}