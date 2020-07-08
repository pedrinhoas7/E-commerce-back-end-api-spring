package com.ondadoacai.apiCadastro.service;

import java.util.List;

import com.ondadoacai.apiCadastro.dao.PessoaDao;
import com.ondadoacai.apiCadastro.models.Pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PessoaServiceImplement implements PessoaService {
    @Autowired
    private PessoaDao dao; 

    
    @Override
    public void save(Pessoa pessoa) {
        if(pessoa.getCpf() == null | pessoa.getEmail() == null | pessoa.getNome() == null | pessoa.getSenha() == null){
                            
        }
        else{
        dao.save(pessoa);
        }

    }

    @Override
    public void delete(Long id) {
       dao.delete(id);

    }

    @Override
    public void update(Pessoa pessoa) {
       dao.update(pessoa);

    }

 
    @Override
    public Pessoa getPessoaId(Long id) {
      return dao.getPessoaId(id);
    }

    @Override
    public List<Pessoa> getPessoa() {
        return dao.getPessoa();
    }
    
}