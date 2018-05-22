package com.pi.model.entidademodel;

import com.pi.dao.EmprestimoDAO;
import com.pi.model.entidadehibernatedao.EmprestimoHibernateDAO;
import java.util.List;
import com.pi.model.entidade.Emprestimo;

public class EmprestimoModel {
    
    private EmprestimoDAO emprestimoDAO;
    
    public EmprestimoModel() {
        this.emprestimoDAO = new EmprestimoHibernateDAO() {};
    }
    
    public void inserirEmprestimo(Emprestimo emprestimo) {
        this.emprestimoDAO.inserir(emprestimo);
    }
    
    public Emprestimo buscarEmprestimo(Integer codigo) {
        return (Emprestimo) this.emprestimoDAO.buscarPorCodigo(codigo);
    }
    
    public void atualizarEmprestimo(Emprestimo emprestimo) {
        this.emprestimoDAO.alterar(emprestimo);
    }
    
    public void deletarEmprestimo(Emprestimo emprestimo) {
        this.emprestimoDAO.deletar(emprestimo);
    }
    
    public List<Emprestimo> buscarTodos() {
        return this.emprestimoDAO.recuperarTodos();
    }

}
