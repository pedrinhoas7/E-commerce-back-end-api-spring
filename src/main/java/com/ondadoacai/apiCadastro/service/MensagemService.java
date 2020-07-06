package com.ondadoacai.apiCadastro.service;

import java.util.List;

import com.ondadoacai.apiCadastro.models.Mensagem;

public interface MensagemService {
    void save(Mensagem mensagem);
    void delete(String id);
    void update(Mensagem mensagem);
    Mensagem getMensagemId(String id);
    List<Mensagem> getMensagens();
}