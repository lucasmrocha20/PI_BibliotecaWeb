package com.pi.dao;

import com.pi.model.entidade.Livro;

public interface LivroDAO extends DAOGenerico<Livro> {
     
    public Livro buscarPorTitulo (String titulo);
    
}