package com.loja.service;
import com.loja.model.Produto;
import com.loja.repository.*;

public class ProdutoServiceImpl implements ProdutoService {
    private ProdutoRepository repo = new ProdutoRepositoryImpl();

    public void adicionar(Produto produto) {
        repo.salvar(produto);
    }

    public Produto[] listar() {
        return repo.listar();
    }

    public Produto buscar(int id) {
        return repo.buscarPorId(id);
    }

    public void atualizar(Produto produto) {
        repo.atualizar(produto);
    }

    public void remover(int id) {
        repo.excluir(id);
    }
}