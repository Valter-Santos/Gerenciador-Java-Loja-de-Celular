package com.seudominio.service;

import com.seudominio.model.Produto;
import com.seudominio.repository.*;

public class ProdutoServiceImpl implements ProdutoService {
    private ProdutoRepository repo = new ProdutoRepositoryImpl();

    public void criarProduto(Produto produto) {
        repo.save(produto);
    }

    public Produto buscarPorId(int id) {
        return repo.findById(id);
    }

    public Produto[] listarTodos() {
        return repo.findAll();
    }
}