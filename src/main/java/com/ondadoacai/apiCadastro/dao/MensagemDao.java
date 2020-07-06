package com.ondadoacai.apiCadastro.dao;

import java.util.List;

import com.ondadoacai.apiCadastro.models.Mensagem;

public interface MensagemDao {
    void save(Mensagem mensagem);
    void delete(Long id);
    void update(Mensagem mensagem);
    Mensagem getMensagemId(Long id);
    List<Mensagem> getMensagens();
}