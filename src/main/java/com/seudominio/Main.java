package com.seudominio;

import com.seudominio.model.Produto;
import com.seudominio.service.*;

public class Main {
    public static void main(String[] args) {
        ProdutoService service = new ProdutoServiceImpl();
        service.criarProduto(new Produto(1, "Capinha"));
        for (Produto p : service.listarTodos()) {
            if (p != null) System.out.println(p.getId() + ": " + p.getNome());
        }
    }
}