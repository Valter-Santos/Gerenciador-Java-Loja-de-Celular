package com.seudominio;

import com.seudominio.model.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Produto> produtos = new ArrayList<>();
        List<Usuario> usuarios = new ArrayList<>();
        List<Venda> historico = new ArrayList<>();

        usuarios.add(new Usuario("admin", "1234", "admin"));
        usuarios.add(new Usuario("vendedor", "0000", "vendedor"));
        produtos.add(new Produto(1, "Capinha Transparente", "Capinha", 19.90, 10));
        produtos.add(new Produto(2, "Fone Bluetooth", "Fone", 59.90, 5));
        produtos.add(new Produto(3, "Carregador Turbo", "Carregador", 39.90, 3));

        Usuario logado = fazerLogin(usuarios, sc);
        if (logado == null) return;

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("[1] Cadastrar novo vendedor");
            System.out.println("[2] Adicionar produto à vitrine");
            System.out.println("[3] Realizar venda");
            System.out.println("[4] Relatório de vendas do vendedor");
            System.out.println("[0] Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome do novo vendedor: ");
                    String nome = sc.nextLine();
                    System.out.print("Senha: ");
                    String senha = sc.nextLine();
                    usuarios.add(new Usuario(nome, senha, "vendedor"));
                    System.out.println("✅ Vendedor cadastrado.");
                }
                case 2 -> {
                    System.out.print("ID do produto: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Tipo: ");
                    String tipo = sc.nextLine();
                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();
                    System.out.print("Quantidade: ");
                    int qtd = sc.nextInt();
                    produtos.add(new Produto(id, nome, tipo, preco, qtd));
                    System.out.println("✅ Produto adicionado.");
                }
                case 3 -> {
                    System.out.print("Nome do cliente: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF do cliente: ");
                    String cpf = sc.nextLine();
                    Cliente cliente = new Cliente(nome, cpf);
                    System.out.println("\nVitrine:");
                    for (Produto p : produtos)
                        System.out.printf("%d - %s | %s | R$%.2f | Estoque: %d\n", p.getId(), p.getNome(), p.getTipo(), p.getPreco(), p.getQuantidade());
                    System.out.print("ID do produto: ");
                    int id = sc.nextInt();
                    System.out.print("Quantidade: ");
                    int qtd = sc.nextInt();
                    Produto escolhido = produtos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
                    if (escolhido != null && escolhido.getQuantidade() >= qtd) {
                        escolhido.reduzirEstoque(qtd);
                        Venda venda = new Venda(cliente, escolhido, logado, qtd);
                        historico.add(venda);
                        System.out.println("✅ Venda concluída!");
                        System.out.println(venda.getResumo());
                    } else {
                        System.out.println("❌ Produto inválido ou estoque insuficiente.");
                    }
                }
                case 4 -> {
                    System.out.println("\n📜 Relatório de vendas do vendedor " + logado.getNome() + ":");
                    for (Venda v : historico)
                        if (v.getVendedor().getNome().equals(logado.getNome()))
                            System.out.println(v.getResumo());
                }
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("❌ Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static Usuario fazerLogin(List<Usuario> usuarios, Scanner sc) {
        System.out.print("🔐 Usuário: ");
        String nome = sc.nextLine();
        System.out.print("🔑 Senha: ");
        String senha = sc.nextLine();
        for (Usuario u : usuarios)
            if (u.getNome().equals(nome) && u.getSenha().equals(senha)) {
                System.out.println("✅ Login realizado como " + u.getTipo());
                return u;
            }
        System.out.println("❌ Login inválido.");
        return null;
    }
}