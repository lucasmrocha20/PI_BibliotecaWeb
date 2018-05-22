package com.pi.model.entidade;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
@ManagedBean(name = "Pessoa")
@RequestScoped
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue
    private Integer codPessoa;

    @Column(length = 50)
    private String nome;

    @Column(length = 15)
    private String CPF;

    @Column(length = 100)
    private String email;

    @Column
    private Integer telefone;
    
    @Column (length = 25)
    private String cidade;
    
    @Column (length = 50)
    private String logradouro;
    
    @Column
    private Integer numero;

    public Pessoa(Integer codPessoa, String nome, String CPF, String email, Integer telefone, String cidade, String logradouro, Integer numero) {
        this.codPessoa = codPessoa;
        this.nome = nome;
        this.CPF = CPF;
        this.email = email;
        this.telefone = telefone;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.numero = numero;
    }
    
    public Pessoa(){
    }

    public Integer getCodPessoa() {
        return codPessoa;
    }

    public void setCodPessoa(Integer codPessoa) {
        this.codPessoa = codPessoa;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

}
