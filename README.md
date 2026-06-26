# Customer Support

## Descrição

O **Customer Support** é uma aplicação web desenvolvida para simular um sistema de atendimento ao cliente. O projeto permite autenticação de usuários, troca de mensagens e gerenciamento do histórico de atendimentos por meio de uma API REST desenvolvida com Spring Boot.

---

## Tecnologias Utilizadas

O projeto foi desenvolvido utilizando as seguintes tecnologias:

| Tecnologia               | Descrição                                                                           |
| ------------------------ | ----------------------------------------------------------------------------------- |
| **Java 21**              | Linguagem principal utilizada no desenvolvimento da aplicação.                      |
| **Spring Boot**          | Framework responsável pela configuração e inicialização da aplicação.               |
| **Spring Web**           | Implementação dos endpoints REST utilizados pela aplicação.                         |
| **Spring Data JPA**      | Camada de persistência para integração com o banco de dados.                        |
| **H2 Database**          | Banco de dados relacional em memória utilizado durante a execução da aplicação.     |
| **Lombok**               | Biblioteca para redução de código repetitivo, como getters, setters e construtores. |
| **HTML5**                | Estrutura da interface do usuário.                                                  |
| **CSS3**                 | Estilização da aplicação.                                                           |
| **JavaScript (Vanilla)** | Implementação da lógica do frontend sem utilização de frameworks externos.          |

---

## Pré-requisitos

Antes de executar o projeto, certifique-se de possuir:

* Java JDK 21
* Maven instalado (ou utilizar o Maven Wrapper incluído no projeto)
* Uma IDE compatível com Java, como:

  * IntelliJ IDEA
  * Eclipse
  * Visual Studio Code

---

## Instalação

### 1. Clonar o repositório

```bash
git clone https://github.com/pietromurillo/customer-support.git
cd customer-support
```

### 2. Executar pela IDE

1. Abra o projeto em sua IDE.
2. Importe-o como um projeto Maven.
3. Aguarde o download das dependências.
4. Execute a classe principal anotada com `@SpringBootApplication`.

### 3. Executar pelo terminal

Na raiz do projeto, execute:

```bash
./mvnw spring-boot:run
```

No Windows:

```bash
mvnw.cmd spring-boot:run
```

---

## Acessando a aplicação

Após a inicialização do Spring Boot, o servidor estará disponível na porta **8080**.

Abra o navegador e acesse:

```text
http://localhost:8080/index.html
```

## Funcionalidades

* Autenticação de usuários
* Interface web para atendimento
* Envio e recebimento de mensagens
* Histórico de atendimentos
* API REST desenvolvida com Spring Boot
* Persistência de dados utilizando H2 Database

---

## Licença

Este projeto foi desenvolvido para fins acadêmicos e de estudo.
