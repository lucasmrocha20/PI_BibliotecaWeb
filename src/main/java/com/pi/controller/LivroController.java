package com.pi.controller;

import java.util.ArrayList;
import com.pi.model.entidade.Livro;
import com.pi.model.entidademodel.LivroModel;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "livroController")
@SessionScoped
public class LivroController {

    private LivroModel livroModel = null;
    private Livro selecionarLivro;
    private Livro cadastroLivro;

    public LivroController() {
        this.livroModel = new LivroModel();
        this.cadastroLivro = new Livro();
    }

    public String adicionarLivroAction() {
        this.livroModel.inserirLivro(this.cadastroLivro);
        this.cadastroLivro = new Livro();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Livro cadastrado com sucesso!"));

        return "/tudolivro.xhtml?faces-redirect=true";
    }

    public void alterarLivroAction() {
        this.livroModel.atualizarLivro(this.selecionarLivro);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Livro alterado com sucesso!"));
    }

    public void excluirLivroAction() {
        this.livroModel.deletarLivro(this.selecionarLivro);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Livro deletado com sucesso!"));
    }

    public List<Livro> recuperarTodos() {
        return this.livroModel.buscarTodos();
    }

    public Livro getSelecionarLivro() {
        return selecionarLivro;
    }

    public void setSelecionarLivro(Livro selecionarLivro) {
        this.selecionarLivro = selecionarLivro;
    }

    public Livro getCadastroLivro() {
        return cadastroLivro;
    }

    public void setCadastroLivro(Livro cadastroLivro) {
        this.cadastroLivro = cadastroLivro;
    }

    public List<String> Livros() {
        List<Livro> l = this.livroModel.buscarTodos();
        List<String> livros = new ArrayList<String>();
        for (Livro titulo : l) {
            livros.add(titulo.getTitulo());
        }
        return livros;
    }

}
