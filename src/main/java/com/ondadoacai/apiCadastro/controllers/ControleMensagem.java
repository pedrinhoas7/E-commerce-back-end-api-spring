package com.ondadoacai.apiCadastro.controllers;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import com.ondadoacai.apiCadastro.models.Mensagem;
import com.ondadoacai.apiCadastro.service.MensagemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// HABILITANDO TRANSAÇOES JPA
@EnableTransactionManagement

// CLASSE CONTROLE
@RestController

// LIBERA ACESSO AS REQUISIÇÕES PARA O FRONT-END 
@CrossOrigin(origins = "http://localhost:4200") 

public class ControleMensagem {
    @Autowired
    private MensagemService service;

    // ENVIANDO UM GET E RETORNANDO A LISTA DE MENSAGENS
    @RequestMapping(value="mensagem/listar", method=RequestMethod.GET)
    public List<Mensagem> getMensagens(){
        return service.getMensagens();
    }

    // ENVIANDO UM GET COM PARAMETRO ID E RETORNANDO O PRODUTO ASSOCIADO AO ID
    @RequestMapping(value = "mensagem/listar/id/", method = RequestMethod.GET)
    @Transactional
    public Mensagem getMensagemId(String id){
        return service.getMensagemId(id);
    }

    // ENVIANDO UM METHOD DELETE PASSANDO UM ID (EXCLUI PRODUTO)
    @RequestMapping(value ="mensagem/deletar", method = RequestMethod.DELETE)
    @Transactional
    public void del(String id){
        service.delete(id);
    }

    // ENVIANDO UM POST PASSANDO O PRODUTO A SER SALVO E CRIANDO UMA URL
    @PostMapping("mensagem/salvar")
    @Transactional
    public ResponseEntity<Void> salvar(@RequestBody Mensagem mensagem){
        service.save(mensagem);
        URI location =ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{email}")
        .buildAndExpand(mensagem.getEmail())
        .toUri();
        return ResponseEntity.created(location).build();

    }
    
    // ENVIANDO UM METHODO PUT PASSANDO O PRODUTO QUE VAI SER ATUALIZADO (REFERENCIA CHAVE PRIMARIA)
    @PutMapping("/mensagem/update")
    @Transactional
    public ResponseEntity<Void> atualiza(@RequestBody Mensagem mensagem){
        service.update(mensagem);
        return null;
    }
    
}