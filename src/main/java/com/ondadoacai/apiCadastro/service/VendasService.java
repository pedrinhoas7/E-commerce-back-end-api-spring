package com.ondadoacai.apiCadastro.service;

import java.util.List;

import com.ondadoacai.apiCadastro.models.Vendas;

public interface VendasService {
    void save(Vendas vendas);
    void update(Vendas vendas);
    void delete(long id);
    List<Vendas> getVendas();
    Vendas getVendaId(int id);
}