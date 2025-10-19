# Cadastro de Ninjas

## 📝 Descrição

**Cadastro de Ninjas** é uma aplicação Full-Stack desenvolvida com Spring Boot que permite o gerenciamento completo de ninjas e suas missões. A aplicação oferece tanto uma API RESTful para integrações quanto uma interface de usuário web interativa construída com Thymeleaf.

O sistema permite criar, listar, atualizar e deletar ninjas, bem como gerenciar as missões às quais eles podem ser associados, tudo de forma intuitiva e eficiente.

## ✨ Funcionalidades

* **Gerenciamento de Ninjas**: Operações CRUD (Criar, Ler, Atualizar, Deletar) completas para os ninjas.
* **Gerenciamento de Missões**: Funcionalidades CRUD para as missões, que podem ser atribuídas aos ninjas.
* **Interface Web (UI)**: Páginas web dinâmicas criadas com Thymeleaf para interagir com o sistema de forma visual e amigável.
* **API RESTful**: Endpoints bem definidos para todas as funcionalidades, permitindo a integração com outras aplicações.
* **Documentação de API**: Geração automática da documentação da API com Springdoc (Swagger), facilitando o teste e a compreensão dos endpoints.
* **Banco de Dados com Migrations**: Utiliza Flyway para um versionamento seguro e automático do esquema do banco de dados.

## 🛠️ Tecnologias Utilizadas

* **Backend**:
    * [Java 17](https://www.oracle.com/java/)
    * [Spring Boot 3.5.4](https://spring.io/projects/spring-boot)
    * [Spring Web](https://docs.spring.io/spring-framework/reference/web.html)
    * [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
* **Frontend (Server-Side)**:
    * [Thymeleaf](https://www.thymeleaf.org/)
* **Banco de Dados**:
    * [H2 Database](https://www.h2database.com/html/main.html) (para ambiente de desenvolvimento)
    * [Flyway](https://flywaydb.org/)
* **Build e Dependências**:
    * [Apache Maven](https://maven.apache.org/)
    * [Lombok](https://projectlombok.org/)
* **API Documentation**:
    * [Springdoc OpenAPI (Swagger UI)](https://springdoc.org/)

## 🚀 Como Executar o Projeto

### Pré-requisitos

* JDK 17 ou superior.
* Apache Maven.

### Configuração

1.  **Clone o repositório:**
    ```bash
    git clone <URL-DO-SEU-REPOSITORIO>
    cd CadastroDeNinjas
    ```

2.  **Configure as variáveis de ambiente (Opcional):**
    Por padrão, a aplicação usa o banco de dados em memória H2. Se desejar usar um banco de dados externo, você pode criar um arquivo `.env` na raiz do projeto (este arquivo está no `.gitignore` por segurança) com as seguintes variáveis:

    ```env
    #CONFIG DATABASE
    DATABASE_URL=jdbc:h2:mem:ninjasdb
    DATABASE_USERNAME=sa
    DATABASE_PASSWORD=password
    ```

### Execução

Utilize o Maven Wrapper para iniciar a aplicação:

```bash
./mvnw spring-boot:run
