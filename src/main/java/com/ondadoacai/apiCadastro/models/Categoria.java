package com.ondadoacai.apiCadastro.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

// GETTERS E SETTERS LOMBOK
@Getter
@Setter

//MAPEANDO A ENTIDADE CATEGORIA
@Entity
@Table(name = "CATEGORIA")
public class Categoria implements Serializable{

    /**
     * SERIALIZABLE ID
     */
    private static final long serialVersionUID = 2888076203530972474L;

    //MAPEANDO A COLUNA ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //MAPEANDO A COLUNA NOME
    @Column(name = "NOME") 
    private String nome;
    
}
