package com.ondadoacai.apiCadastro.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Any;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "VENDAS")
public class Vendas implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Pessoa.class) 
    @JoinColumn(name = "CPF_CLIENTE", referencedColumnName = "CPF")
    private Pessoa usuario;

    @Column(name = "ENDEREÇO")
    private String endereço;

    @Column(name = "VALOR")
    private float valor;

    @Column(name = "DATACOMPRA")
    private float dataCompra;

    @Column(name = "DATAENTREGA")
    private float dataEntrega;

    @Column(name = "FRETE")
    private float frete;

    @Column(name = "PRODUTOS")
    private int produtos;
    
    
}