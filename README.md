# 🥋 Cadastro de Ninjas

## 📝 Descrição

**Cadastro de Ninjas** é uma aplicação Full-Stack desenvolvida com **Java 17 e Spring Boot**, focada no gerenciamento completo de ninjas e suas missões. O projeto foi projetado para ser **altamente portátil e consistente**, utilizando a containerização para encapsular a API e o banco de dados.

A aplicação oferece tanto uma **API RESTful** para integrações quanto uma **Interface de Usuário Web (UI)** interativa construída com Thymeleaf. O sistema permite criar, listar, atualizar e deletar ninjas, bem como gerenciar as missões às quais eles podem ser associados.

## ✨ Funcionalidades

* **Containerização Completa:** O ambiente de desenvolvimento é orquestrado via **Docker Compose**, garantindo que a API e o **PostgreSQL** rodem de forma isolada e consistente.
* **Gerenciamento de Ninjas e Missões:** Operações CRUD (Criar, Ler, Atualizar, Deletar) completas para ambas as entidades.
* **Versionamento Seguro (Migrations):** Utiliza **Flyway** para um versionamento seguro e automático do esquema do banco de dados.
* **API RESTful:** Endpoints bem definidos para todas as funcionalidades.
* **Documentação de API:** Geração automática da documentação com **Springdoc (Swagger UI)**, facilitando o teste e a compreensão dos endpoints.

## 🛠️ Tecnologias Utilizadas

| Categoria | Tecnologia | Detalhe |
| :--- | :--- | :--- |
| **Backend** | Java 17 & Spring Boot 3.5.4 | Framework para desenvolvimento da API RESTful. |
| **Containerização** | **Docker** & **Docker Compose** | Criação de imagens e orquestração do ambiente (API + Banco de Dados). |
| **Banco de Dados** | **PostgreSQL** | Banco de dados relacional (Substituindo o H2 para produção/teste). |
| **Migrations** | Flyway | Gerenciamento de schema e versionamento do banco de dados. |
| **Persistência** | Spring Data JPA & Hibernate 6 | Camada de abstração e mapeamento objeto-relacional (ORM). |
| **Interface** | Thymeleaf | Motor de templates para renderização das páginas web. |
| **Utilitários** | Maven & Lombok | Gerenciamento de dependências e redução de código *boilerplate*. |

## 🚀 Como Executar o Projeto (Containerizado)

A maneira recomendada para iniciar o projeto é utilizando o Docker Compose, garantindo que o PostgreSQL e a API rodem corretamente.

### Pré-requisitos

1.  **Docker Desktop:** Instalação do Docker e Docker Compose.
2.  **Maven:** Para gerar o arquivo JAR antes do *build* da imagem.

### 1. Configuração do Arquivo `.env`

Crie um arquivo chamado **`.env`** na raiz do projeto (este arquivo é ignorado pelo Git por segurança) e configure as credenciais do seu banco de dados PostgreSQL:

```env
# Exemplo de conteúdo para o arquivo .env
DATABASE_USER=postgres
DATABASE_PASSWORD=minha_senha_secreta
