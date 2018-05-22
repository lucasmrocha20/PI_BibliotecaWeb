package com.pi.model.entidade;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="emprestimo")
@ManagedBean(name="Emprestimo")
@RequestScoped
public class Emprestimo implements Serializable {
    
    @Id
    @GeneratedValue
    private Integer codEmprestimo;
    
    @OneToOne
    private Livro livro;
    
    @OneToOne
    private Pessoa pessoa;
    
    @Column
    private String dataEmprestimo;
    
    @Column
    private String dataDevolucao;

    public Emprestimo(Integer codEmprestimo, Livro livro, Pessoa pessoa, String dataEmprestimo, String dataDevolucao) {
        this.codEmprestimo = codEmprestimo;
        this.livro = livro;
        this.pessoa = pessoa;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }
    
    public Emprestimo(){
    }

    public Integer getCodEmprestimo() {
        return codEmprestimo;
    }

    public void setCodEmprestimo(Integer codEmprestimo) {
        this.codEmprestimo = codEmprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    
}
