package com.seudominio.repository;

import com.seudominio.model.Produto;

public interface ProdutoRepository {
    void save(Produto produto);
    Produto findById(int id);
    Produto[] findAll();
}