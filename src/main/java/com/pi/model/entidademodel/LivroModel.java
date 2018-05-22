package com.pi.model.entidademodel;

import com.pi.dao.LivroDAO;
import java.util.List;
import com.pi.model.entidade.Livro;
import com.pi.model.entidadehibernatedao.LivroHibernateDAO;

public class LivroModel {
    
    private LivroDAO livroDAO;
    
    public LivroModel() {
        this.livroDAO = new LivroHibernateDAO();
    }
    
    public void inserirLivro(Livro livro) {
        this.livroDAO.inserir(livro);
    }
    
    public Livro buscarLivro(Integer codigo) {
        return (Livro) this.livroDAO.buscarPorCodigo(codigo);
    }
    
    public void atualizarLivro(Livro livro) {
        this.livroDAO.alterar(livro);
    }
    
    public void deletarLivro(Livro livro) {
        this.livroDAO.deletar(livro);
    }
    
    public List<Livro> buscarTodos() {
        return this.livroDAO.recuperarTodos();
    }
    
}