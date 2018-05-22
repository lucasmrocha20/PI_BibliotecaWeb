package com.pi.model.entidademodel;

import com.pi.dao.PessoaDAO;
import com.pi.model.entidadehibernatedao.PessoaHibernateDAO;
import java.util.List;
import com.pi.model.entidade.Pessoa;

public class PessoaModel {
    
    private PessoaDAO pessoaDAO;
    
    public PessoaModel() {
        this.pessoaDAO = new PessoaHibernateDAO();
    }
    
    public void inserirPessoa(Pessoa pessoa) {
        this.pessoaDAO.inserir(pessoa);
    }
    
    public void atualizarPessoa(Pessoa pessoa) {
        this.pessoaDAO.alterar(pessoa);
    }
    
    public void deletarPessoa(Pessoa pessoa) {
        this.pessoaDAO.deletar(pessoa);
    }
    
    public List<Pessoa> buscarTodos() {
        return this.pessoaDAO.recuperarTodos();
    }
}