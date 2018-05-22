package com.pi.dao;

import java.util.List;

public interface DAOGenerico<G> {

    public void inserir(G g);
    public void deletar(G g);
    public void alterar(G g);
    public List<G> recuperarTodos();
    public G buscarPorCodigo(Integer codigo);

}
