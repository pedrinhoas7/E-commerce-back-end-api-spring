package com.ondadoacai.apiCadastro.controllers;

import java.net.URI;
import java.util.List;

import com.ondadoacai.apiCadastro.models.Produto;
import com.ondadoacai.apiCadastro.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.RequestMethod;

// HABILITANDO TRANSAÇOES JPA
@EnableTransactionManagement

// CLASSE CONTROLE
@RestController

// LIBERA ACESSO AS REQUISIÇÕES PARA O FRONT-END 
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ControleProduto {

    // INJETANDO O PRODUTO SERVICE
    @Autowired
    private ProdutoService service;

    // ENVIANDO UM GET E RETORNANDO A LISTA DE PRODUTOS
    @RequestMapping(value="/listarTodos", method=RequestMethod.GET)
    public List<Produto> listar(){
        return service.getProdutos();
    }

    // ENVIANDO UM GET COM PARAMETRO ID E RETORNANDO O PRODUTO ASSOCIADO AO ID
    @RequestMapping(value = "/listarId", method = RequestMethod.GET)
    @Transactional
    public Produto getProduto(Long id){
        return service.getProdutoId(id);
    }

    // ENVIANDO UM METHOD DELETE PASSANDO UM ID (EXCLUI PRODUTO)
    @RequestMapping(value ="/deletar", method = RequestMethod.DELETE)
    @Transactional
    public void del(Long id){
        service.delete(id);
    }

    // ENVIANDO UM POST PASSANDO O PRODUTO A SER SALVO E CRIANDO UMA URL
    @PostMapping("/salvar")
    @Transactional
    public ResponseEntity<Void> salvar(@RequestBody Produto produto){
        service.save(produto);
        URI location =ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(produto.getId())
        .toUri();
        return ResponseEntity.created(location).build();

    }
    
    // ENVIANDO UM METHODO PUT PASSANDO O PRODUTO QUE VAI SER ATUALIZADO (REFERENCIA CHAVE PRIMARIA)
    @PutMapping("/atualizar")
    @Transactional
    public ResponseEntity<Void> atualiza(@RequestBody Produto produto){
        service.update(produto);
        return null;
    }
    

}