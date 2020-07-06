    package com.ondadoacai.apiCadastro.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

//GETTER E SETTERS LOMBOOK
@Getter
@Setter

//MAPEANDO A CLASSE PRODUTO
@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable{

    /**
     * SERIALIZABLE ID
     */
    private static final long serialVersionUID = -6648263362761019858L;

    //MAPEANDO A COLUNA ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    //MAPEANDO A COLUNA CATEGORIA - CHAVE ESTRANGEIRA
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Categoria.class) 
    @JoinColumn(name = "ID_CATEGORIA", referencedColumnName = "ID")
    private Categoria categoria;

    //MAPEANDO A COLUNA NOME
    @Column(name = "NOME") 
    private String nome;

    //MAPEANDO A COLUNA DESCRICAO
    @Column(name = "DESCRICAO") 
    private String descricao;

    //MAPEANDO A COLUNA VALOR
    @Column(name = "VALOR") 
    private float valor;
    
    //MAPEANDO A COLUNA QUANTIDADE
    @Column(name = "QUANTIDADE") 
    private int quantidade;



}