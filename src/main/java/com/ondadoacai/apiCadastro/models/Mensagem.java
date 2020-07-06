package com.ondadoacai.apiCadastro.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "MENSAGEM")
public class Mensagem implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8961997615196884487L;

    @Id
    @Column(name = "EMAIL")
    private String email;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Pessoa.class) 
    @JoinColumn(name = "CPF_CLIENTE", referencedColumnName = "CPF")
    private Pessoa usuario;
   
    @Column(name = "TELEFONE")
    private String telefone;

    @Column(name = "MENSAGEM")
    private String mensagem;

}