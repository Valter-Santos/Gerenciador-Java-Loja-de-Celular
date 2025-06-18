package com.loja;

import com.loja.model.*;
import com.loja.service.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProdutoService produtoService = new ProdutoServiceImpl();
        List<Venda> vendas = new ArrayList<>();
        List<Usuario> usuarios = new ArrayList<>();

        usuarios.add(new Usuario("admin", "1234", "admin"));
        usuarios.add(new Usuario("vendedor", "0000", "vendedor"));

        System.out.print("🔐 Usuário: ");
        String login = sc.nextLine();
        System.out.print("🔑 Senha: ");
        String senha = sc.nextLine();

        Usuario logado = null;
        for (Usuario u : usuarios)
            if (u.getNome().equals(login) && u.getSenha().equals(senha)) logado = u;

        if (logado == null) {
            System.out.println("❌ Login inválido.");
            return;
        }

        // Produtos pré-cadastrados
        produtoService.adicionar(new Produto(1, "Galaxy A14", "Samsung", 999.90, 10));
        produtoService.adicionar(new Produto(2, "iPhone 11", "Apple", 2899.00, 5));
        produtoService.adicionar(new Produto(3, "Moto G73", "Motorola", 1599.00, 8));
        produtoService.adicionar(new Produto(4, "Redmi Note 12", "Xiaomi", 1399.00, 12));
        produtoService.adicionar(new Produto(5, "Galaxy S22", "Samsung", 3499.00, 3));


        int opcao;
        do {
            System.out.println("\n📋 MENU:");
            System.out.println("[1] Cadastrar produtos");
            System.out.println("[2] Listar produtos");
            System.out.println("[3] Atualizar produtos");
            System.out.println("[4] Excluir produto");
            System.out.println("[5] Realizar venda");
            System.out.println("[6] Ver histórico de vendas");
            System.out.println("[0] Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt(); sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();
                    System.out.print("Estoque: ");
                    int estoque = sc.nextInt();
                    produtoService.adicionar(new Produto(id, modelo, marca, preco, estoque));
                }
                case 2 -> {
                    for (Produto c : produtoService.listar())
                        System.out.printf("%d - %s %s | R$%.2f | Estoque: %d\n",
                            c.getId(), c.getMarca(), c.getModelo(), c.getPreco(), c.getEstoque());
                }
                case 3 -> {
                    System.out.print("ID do celular: ");
                    int id = sc.nextInt(); sc.nextLine();
                    Produto c = produtoService.buscar(id);
                    if (c != null) {
                        System.out.print("Novo modelo: ");
                        c.setModelo(sc.nextLine());
                        System.out.print("Nova marca: ");
                        c.setMarca(sc.nextLine());
                        System.out.print("Novo preço: ");
                        c.setPreco(sc.nextDouble());
                        System.out.print("Novo estoque: ");
                        c.setEstoque(sc.nextInt());
                        produtoService.atualizar(c);
                    } else {
                        System.out.println("❌ Celular não encontrado.");
                    }
                }
                case 4 -> {
                    System.out.print("ID do celular: ");
                    int id = sc.nextInt();
                    produtoService.remover(id);
                    System.out.println("🗑️ Celular removido.");
                }
                case 5 -> {
                    System.out.print("Nome do cliente: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF do cliente: ");
                    String cpf = sc.nextLine();
                    Cliente cliente = new Cliente(nome, cpf);

                    for (Produto c : produtoService.listar())
                        System.out.printf("%d - %s %s | R$%.2f | Estoque: %d\n",
                            c.getId(), c.getMarca(), c.getModelo(), c.getPreco(), c.getEstoque());
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.print("Quantidade: ");
                    int qtd = sc.nextInt();

                    Produto escolhido = produtoService.buscar(id);
                    if (escolhido != null && escolhido.getEstoque() >= qtd) {
                        escolhido.reduzirEstoque(qtd);
                        Venda venda = new Venda(cliente, escolhido, logado, qtd);
                        vendas.add(venda);
                        System.out.println("✅ Venda realizada!");
                        System.out.println(venda.getResumo());
                    } else {
                        System.out.println("❌ Estoque insuficiente ou celular não encontrado.");
                    }
                }
                case 6 -> {
                    System.out.println("📜 Histórico de Vendas:");
                    for (Venda v : vendas) System.out.println(v.getResumo());
                }
                case 0 -> System.out.println("👋 Saindo...");
                default -> System.out.println("❌ Opção inválida.");
            }
        } while (opcao != 0);
    }
}