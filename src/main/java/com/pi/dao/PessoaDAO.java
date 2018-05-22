package com.pi.dao;

import com.pi.model.entidade.Pessoa;

public interface PessoaDAO extends DAOGenerico<Pessoa>{
    
    public Pessoa buscarPorNome (String Nome);

}
