package com.ondadoacai.apiCadastro.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PESSOA")
public class Pessoa implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 6973752912225856868L;

    @Id
    @Column(name = "CPF")
    private Long cpf;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SENHA")
    private String senha;

    @Column(name = "RUA")
    private String rua;

    @Column(name = "CIDADE")
    private String cidade;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "CEP")
    private Long cep;

    @Column(name = "FONE")
    private Long fone;

    @Column(name = "TIPO")
    private String tipo;

}