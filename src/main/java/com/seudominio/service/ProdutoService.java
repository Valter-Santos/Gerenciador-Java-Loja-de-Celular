package com.seudominio.service;

import com.seudominio.model.Produto;

public interface ProdutoService {
    void criarProduto(Produto produto);
    Produto buscarPorId(int id);
    Produto[] listarTodos();
}