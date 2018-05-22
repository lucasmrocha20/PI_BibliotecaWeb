package com.pi.model.entidadehibernatedao;

import com.pi.dao.EmprestimoDAO;
import com.pi.model.entidade.Emprestimo;
import com.pi.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmprestimoHibernateDAO implements EmprestimoDAO{
    private final SessionFactory sessionFactory;
    
    public EmprestimoHibernateDAO(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    @Override
    public void inserir(Emprestimo emprestimo) {
        Session session = this.sessionFactory.openSession();
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            session.save(emprestimo);
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
    public void deletar(Emprestimo emprestimo) {
        Session session = this.sessionFactory.openSession();
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            session.delete(emprestimo);
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
    public Emprestimo buscarPorCodigo(Integer codPessoa) {
        Session session = this.sessionFactory.openSession();
        Emprestimo emprestimo = null;
        try {
            return emprestimo = (Emprestimo) session.createQuery("SELECT emprestimo FROM Emprestimo emprestimo WHERE emprestimo.codEmprestimo = :codEmprestimo").getResultList().get(0);
        } catch(RuntimeException ex) {
            throw ex;
        } finally {
            session.close();
        }
    }

    @Override
    public void alterar(Emprestimo emprestimo) {
        Session session = this.sessionFactory.openSession();
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            session.update(emprestimo);
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
    public List<Emprestimo> recuperarTodos() {
        Session session = this.sessionFactory.openSession();
        List<Emprestimo> emprestimos = null;
        try {
            return emprestimos = session.createQuery("SELECT emprestimo FROM Emprestimo emprestimo").list();
        } catch(RuntimeException ex) {
            throw ex;
        } finally {
            session.close();
        }
    }    
}
