package com.seudominio.repository;

import com.seudominio.model.Produto;

public class ProdutoRepositoryImpl implements ProdutoRepository {
    private Produto[] produtos = new Produto[10];
    private int count = 0;

    public void save(Produto produto) {
        produtos[count++] = produto;
    }

    public Produto findById(int id) {
        for (Produto p : produtos) {
            if (p != null && p.getId() == id) return p;
        }
        return null;
    }

    public Produto[] findAll() {
        return produtos;
    }
}