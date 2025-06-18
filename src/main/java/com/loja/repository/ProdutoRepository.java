package com.loja.repository;
import com.loja.model.Produto;

public interface ProdutoRepository {
    void salvar(Produto produto);
    Produto buscarPorId(int id);
    Produto[] listar();
    void atualizar(Produto produto);
    void excluir(int id);
}