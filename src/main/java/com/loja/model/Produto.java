package com.loja.model;
public class Produto {
    private int id;
    private String modelo;
    private String marca;
    private double preco;
    private int estoque;

    public Produto(int id, String modelo, String marca, double preco, int estoque) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.preco = preco;
        this.estoque = estoque;
    }

    public int getId() { return id; }
    public String getModelo() { return modelo; }
    public String getMarca() { return marca; }
    public double getPreco() { return preco; }
    public int getEstoque() { return estoque; }

    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setPreco(double preco) { this.preco = preco; }
    public void setEstoque(int estoque) { this.estoque = estoque; }

    public void reduzirEstoque(int qtd) { this.estoque -= qtd; }
}
