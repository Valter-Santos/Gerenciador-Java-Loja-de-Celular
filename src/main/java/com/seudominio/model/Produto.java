package com.seudominio.model;

public class Produto {
    private int id;
    private String nome;
    private String tipo;
    private double preco;
    private int quantidade;

    public Produto(int id, String nome, String tipo, double preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getTipo() { return tipo; }
    public double getPreco() { return preco; }
    public int getQuantidade() { return quantidade; }

    public void reduzirEstoque(int quantidadeComprada) {
        this.quantidade -= quantidadeComprada;
    }
}
