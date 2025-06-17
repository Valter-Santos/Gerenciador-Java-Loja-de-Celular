package com.seudominio.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Venda {
    private Cliente cliente;
    private Produto produto;
    private Usuario vendedor;
    private int quantidade;
    private double valorTotal;
    private String dataHora;

    public Venda(Cliente cliente, Produto produto, Usuario vendedor, int quantidade) {
        this.cliente = cliente;
        this.produto = produto;
        this.vendedor = vendedor;
        this.quantidade = quantidade;
        this.valorTotal = produto.getPreco() * quantidade;
        this.dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public String getResumo() {
        return String.format("Vendedor: %s | Cliente: %s (%s) | Produto: %s | Qtde: %d | Total: R$%.2f | Data: %s",
            vendedor.getNome(), cliente.getNome(), cliente.getCpf(), produto.getNome(), quantidade, valorTotal, dataHora);
    }

    public Usuario getVendedor() {
        return vendedor;
    }
}
