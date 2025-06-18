package com.loja.service;
import com.loja.model.Produto;

public interface ProdutoService {
    void adicionar(Produto produto);
    Produto[] listar();
    Produto buscar(int id);
    void atualizar(Produto produto);
    void remover(int id);
}