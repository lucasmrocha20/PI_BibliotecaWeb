package com.pi.model.entidadehibernatedao;

import com.pi.dao.PessoaDAO;
import com.pi.model.entidade.Pessoa;
import com.pi.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PessoaHibernateDAO implements PessoaDAO{
    private final SessionFactory sessionFactory;
    
    public PessoaHibernateDAO(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    @Override
    public void inserir(Pessoa pessoa) {
        Session session = this.sessionFactory.openSession();
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            session.save(pessoa);
            trans.commit();
        } catch(HibernateException ex) {
            if(trans != null) {
                trans.rollback();
            }
            throw ex;
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Pessoa pessoa) {
        Session session = this.sessionFactory.openSession();
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            session.delete(pessoa);
            trans.commit();
        } catch(HibernateException ex) {
            if(trans != null) {
                trans.rollback();
            }
            throw ex;
        } finally {
            session.close();
        }
    }

    @Override
    public Pessoa buscarPorCodigo(Integer codPessoa) {
        Session session = this.sessionFactory.openSession();
        Pessoa pessoa = null;
        try {
            return pessoa = (Pessoa) session.createQuery("SELECT pessoa FROM Pessoa pessoa WHERE pessoa.codPessoa = :codPessoa").getResultList().get(0);
        } catch(RuntimeException ex) {
            throw ex;
        } finally {
            session.close();
        }
    }

    @Override
    public void alterar(Pessoa pessoa) {
        Session session = this.sessionFactory.openSession();
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            session.update(pessoa);
            trans.commit();
        } catch(HibernateException ex) {
            if(trans != null) {
                trans.rollback();
            }
            throw ex;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Pessoa> recuperarTodos() {
        Session session = this.sessionFactory.openSession();
        List<Pessoa> pessoas = null;
        try {
            return pessoas = session.createQuery("SELECT pessoa FROM Pessoa pessoa").list();
        } catch(RuntimeException ex) {
            throw ex;
        } finally {
            session.close();
        }
    }

    @Override
    public Pessoa buscarPorNome(String Nome) {
        //Verificar com Vilmar
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}