📱 Sistema de Gestão para Loja de Celulares - Java

Este repositório contém um sistema desktop desenvolvido em **Java puro**, com foco na gestão de lojas de celulares. O sistema é executado via **console (terminal)**
e foi estruturado para seguir boas práticas com **camadas Model, Repository e Service**.

---

🔧 Funcionalidades

* 📦 **Cadastro e controle de produtos** (celulares, fones, capinhas, etc.)
* 🧾 **Registro de vendas** com cálculo automático de valor total
* 👤 **Cadastro e exibição de clientes** no momento da venda
* 🔧 **Controle de ordens de serviço** (assistência técnica) (em desenvolvimento)
* 📊 **Relatórios simples** de vendas e estoque
* 🔐 **Sistema de login com níveis de acesso** (admin e vendedor)
* 🧭 **Menu interativo no terminal** para navegação entre funcionalidades

---

 🧱 Arquitetura

O projeto segue o padrão de organização em três camadas:

```
src/
├── model/        → Entidades do sistema (Produto, Cliente, Usuario, Venda)
├── repository/   → Repositórios com armazenamento em arrays tradicionais
├── service/      → Lógica de negócio
└── Main.java     → Menu principal e fluxo de interação
```

---

💻 Tecnologias Utilizadas

* **Linguagem:** Java 11+
* **IDE:** IntelliJ IDEA (recomendado)
* **Armazenamento:** Arrays tradicionais (sem banco de dados)
