package com.ondadoacai.apiCadastro.controllers;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import com.ondadoacai.apiCadastro.models.Pessoa;
import com.ondadoacai.apiCadastro.service.PessoaService;

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

public class ControlePessoa {
    // INJETANDO O PRODUTO SERVICE
    @Autowired
    private PessoaService service;

    // ENVIANDO UM GET E RETORNANDO A LISTA DE PRODUTOS
    @RequestMapping(value="/listarPessoas", method=RequestMethod.GET)
    public List<Pessoa> getPessoa(){
        return service.getPessoa();
    }

    // ENVIANDO UM GET COM PARAMETRO ID E RETORNANDO O PRODUTO ASSOCIADO AO ID
    @RequestMapping(value = "/listarCpf", method = RequestMethod.GET)
    @Transactional
    public Pessoa getPessoaId(Long id){
        return service.getPessoaId(id);
    }

    // ENVIANDO UM METHOD DELETE PASSANDO UM ID (EXCLUI PRODUTO)
    @RequestMapping(value ="/deletarPessoa", method = RequestMethod.DELETE)
    @Transactional
    public void del(Long id){
        service.delete(id);
    }

    // ENVIANDO UM POST PASSANDO O PRODUTO A SER SALVO E CRIANDO UMA URL
    @PostMapping("/salvarPessoa")
    @Transactional
    public ResponseEntity<Void> salvar(@RequestBody Pessoa pessoa){
        service.save(pessoa);
        URI location =ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{cpf}")
        .buildAndExpand(pessoa.getCpf())
        .toUri();
        return ResponseEntity.created(location).build();

    }
    
    // ENVIANDO UM METHODO PUT PASSANDO O PRODUTO QUE VAI SER ATUALIZADO (REFERENCIA CHAVE PRIMARIA)
    @PutMapping("/updatePessoa")
    @Transactional
    public ResponseEntity<Void> atualiza(@RequestBody Pessoa pessoa){
        service.update(pessoa);
        return null;
    }
    
}