package com.pi.controller;

import java.util.ArrayList;
import com.pi.model.entidade.Pessoa;
import com.pi.model.entidademodel.PessoaModel;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="pessoaController")
@SessionScoped
public class PessoaController {
    private PessoaModel pessoaModel = null;
    private Pessoa selecionarPessoa;
    private Pessoa cadastroPessoa;

    public PessoaController() {
        this.pessoaModel = new PessoaModel();
        this.cadastroPessoa = new Pessoa();
    }

    public String adicionarPessoaAction() {
        this.pessoaModel.inserirPessoa(this.cadastroPessoa);
        this.cadastroPessoa = new Pessoa();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pessoa cadastrada com sucesso!"));
        
        return "/pagesClientes/visualizarCad.xhtml";
    }

    public void alterarPessoaAction() {
            this.pessoaModel.atualizarPessoa(this.selecionarPessoa);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pessoa alterada com sucesso!"));
    }

    public void excluirPessoaAction() {
            this.pessoaModel.deletarPessoa(this.selecionarPessoa);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pessoa deletada com sucesso!"));
    }

    public List<Pessoa> recuperarTodos() {
        return this.pessoaModel.buscarTodos();
    }
    
    public Pessoa getSelecionarPessoa() {
        return selecionarPessoa;
    }

    public void setSelecionarPessoa(Pessoa selecionarPessoa) {
        this.selecionarPessoa = selecionarPessoa;
    }
    
    public Pessoa getCadastroPessoa (){
        return cadastroPessoa;
    }
    
    public void setCadastroPessoa (Pessoa cadastroPessoa){
        this.cadastroPessoa = cadastroPessoa;
    }
    
    public List<String> Pessoas(){
        List<Pessoa> p = this.pessoaModel.buscarTodos();
        List<String> pessoas = new ArrayList<String>();
        for (Pessoa nome : p){
            pessoas.add(nome.getNome());
        }
        return pessoas;
    }
    
}
