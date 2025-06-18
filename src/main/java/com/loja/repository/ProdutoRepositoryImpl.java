package com.loja.repository;
import com.loja.model.Produto;

public class ProdutoRepositoryImpl implements ProdutoRepository {
    private Produto[] celulares = new Produto[100];
    private int contador = 0;

    public void salvar(Produto produto) {
        celulares[contador++] = produto;
    }

    public Produto buscarPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (celulares[i].getId() == id) return celulares[i];
        }
        return null;
    }

    public Produto[] listar() {
        Produto[] lista = new Produto[contador];
        for (int i = 0; i < contador; i++) lista[i] = celulares[i];
        return lista;
    }

    public void atualizar(Produto produto) {
        for (int i = 0; i < contador; i++) {
            if (celulares[i].getId() == produto.getId()) {
                celulares[i] = produto;
                break;
            }
        }
    }

    public void excluir(int id) {
        for (int i = 0; i < contador; i++) {
            if (celulares[i].getId() == id) {
                for (int j = i; j < contador - 1; j++) {
                    celulares[j] = celulares[j + 1];
                }
                celulares[--contador] = null;
                break;
            }
        }
    }
}