package com.pi.controller;

import com.pi.model.entidademodel.EmprestimoModel;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.pi.model.entidade.Emprestimo;
import com.pi.model.entidade.Livro;
import com.pi.model.entidade.Pessoa;
import com.pi.model.entidademodel.LivroModel;

@ManagedBean(name = "emprestimoController")
@SessionScoped
public class EmprestimoController {

    private EmprestimoModel emprestimoModel = null;
    private Emprestimo selecionarEmprestimo;
    private Emprestimo cadastroEmprestimo;
    private LivroModel livroModel;
    private Livro selecionarLivro;
    private Pessoa selecionarPessoa;

    public EmprestimoController() {
        this.emprestimoModel = new EmprestimoModel();
        this.cadastroEmprestimo = new Emprestimo();
        this.selecionarLivro = new Livro();
        this.selecionarPessoa = new Pessoa();
        this.livroModel = new LivroModel();
    }

    public void adicionarEmprestimoAction() {
        if (!selecionarLivro.isEmprestado()) {
            this.cadastroEmprestimo.setLivro(selecionarLivro);
            this.cadastroEmprestimo.setPessoa(selecionarPessoa);
            this.cadastroEmprestimo.setDataEmprestimo("");
            this.emprestimoModel.inserirEmprestimo(this.cadastroEmprestimo);

            selecionarLivro.setEmprestado(true);
            this.livroModel.atualizarLivro(selecionarLivro);

            this.cadastroEmprestimo = new Emprestimo();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empréstimo cadastrado com sucesso!"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Livro já emprestado"));
        }
    }

    public void Devolucao() {

        this.getCadastroEmprestimo().setLivro(selecionarLivro);
        this.getCadastroEmprestimo().setPessoa(selecionarPessoa);
        this.getCadastroEmprestimo().setDataDevolucao("22/04/2018");

        selecionarLivro.setEmprestado(false);
        this.livroModel.atualizarLivro(selecionarLivro);

        this.cadastroEmprestimo = new Emprestimo();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empréstimo devolvido com sucesso!"));
    }

    public Emprestimo getSelecionarEmprestimo() {
        return selecionarEmprestimo;
    }

    public void setSelecionarEmprestimo(Emprestimo selecionarEmprestimo) {
        this.selecionarEmprestimo = selecionarEmprestimo;
    }

    public Emprestimo getCadastroEmprestimo() {
        return cadastroEmprestimo;
    }

    public void setCadastroEmprestimo(Emprestimo cadastroEmprestimo) {
        this.cadastroEmprestimo = cadastroEmprestimo;
    }

    public EmprestimoModel getEmprestimoModel() {
        return emprestimoModel;
    }

    public void setEmprestimoModel(EmprestimoModel emprestimoModel) {
        this.emprestimoModel = emprestimoModel;
    }

    public LivroModel getLivroModel() {
        return livroModel;
    }

    public void setLivroModel(LivroModel livroModel) {
        this.livroModel = livroModel;
    }

    public Livro getSelecionarLivro() {
        return selecionarLivro;
    }

    public void setSelecionarLivro(Livro selecionarLivro) {
        this.selecionarLivro = selecionarLivro;
    }

    public Pessoa getSelecionarPessoa() {
        return selecionarPessoa;
    }

    public void setSelecionarPessoa(Pessoa selecionarPessoa) {
        this.selecionarPessoa = selecionarPessoa;
    }

}
