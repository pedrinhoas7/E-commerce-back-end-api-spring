package com.ondadoacai.apiCadastro.controllers;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import com.ondadoacai.apiCadastro.models.Vendas;
import com.ondadoacai.apiCadastro.service.VendasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@EnableTransactionManagement
@RestController
public class ControleVendas {

    @Autowired
    private VendasService service;
    // ENVIANDO UM GET E RETORNANDO A LISTA DE PRODUTOS
    @RequestMapping(value="vendas/listar", method=RequestMethod.GET)
    public List<Vendas> listar(){
        return service.getVendas();
    }

    // ENVIANDO UM GET COM PARAMETRO ID E RETORNANDO O PRODUTO ASSOCIADO AO ID
    @RequestMapping(value = "vendas/listar/id", method = RequestMethod.GET)
    @Transactional
    public Vendas getProduto(int id){
        return service.getVendaId(id);
    }

    // ENVIANDO UM METHOD DELETE PASSANDO UM ID (EXCLUI PRODUTO)
    @RequestMapping(value ="vendas/deletar/id", method = RequestMethod.DELETE)
    @Transactional
    public void del(Long id){
        service.delete(id);
    }

    // ENVIANDO UM POST PASSANDO O PRODUTO A SER SALVO E CRIANDO UMA URL
    @PostMapping("vendas/salvar")
    @Transactional
    public ResponseEntity<Void> salvar(@RequestBody Vendas vendas){
        service.save(vendas);
        URI location =ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(vendas.getId())
        .toUri();
        return ResponseEntity.created(location).build();

    }
    
    // ENVIANDO UM METHODO PUT PASSANDO O PRODUTO QUE VAI SER ATUALIZADO (REFERENCIA CHAVE PRIMARIA)
    @PutMapping("vendas/atualizar")
    @Transactional
    public ResponseEntity<Void> atualiza(@RequestBody Vendas venda){
        service.update(venda);
        return null;
    }
    
}