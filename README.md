# ForumHub
## Descrição

ForumHub é uma API de fórum construída com Spring Boot que permite autenticação de usuários, criação, atualização, listagem e exclusão de tópicos. A API utiliza um banco de dados MySQL para armazenamento de dados.

## Funcionalidades

- **Autenticação de Usuários:**  Autenticação via JWT para proteger as ações na API.
- **CRUD de Tópicos:** Criação, leitura, atualização e exclusão de tópicos no fórum.
- **Listagem de Tópicos:** Listar tópicos com paginação e ordenação por data de criação.
- **Detalhamento de Tópicos:** Exibir detalhes de um tópico específico.
- **Busca por Critérios:** Buscar tópicos por nome de curso e ano específico.


## Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3.3.0**
- **JWT (JSON Web Token)**
- **MySQL**
- **Maven**

## Dependências
Aqui estão algumas das dependências principais utilizadas no projeto:

- **Lombok**
- **Spring Web**
- **Spring Boot DevTools**
- **Spring Data JPA**
- **Flyway Migration**
- **MySQL Driver**
- **Validation**
- **Spring Security**

## Configuração do Banco de Dados
O projeto utiliza um banco de dados MySQL. Certifique-se de ter o MySQL instalado e configurado em sua máquina. Configure as seguintes propriedades no arquivo `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/NOME_BANCO_DE_DADOS
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update
spring.security.enabled=false
server.error.include-stacktrace=never
api.security.token.secret=${JWT_SECRET:SUA_CHAVE_SECRETA}```
```

Substitua SEU_USUARIO, SUA_SENHA, SUA_CHAVE_SECRETA e NOME_BANCO_DE_DADOS pelos valores adequados para sua configuração.

## Estrutura do Banco de Dados
**Tabela de Tópicos**
```
CREATE TABLE topico (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    mensagem TEXT NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    estado ENUM('NAO_RESPONDIDO', 'NAO_SOLUCIONADO', 'SOLUCIONADO', 'FECHADO') NOT NULL,
    autor VARCHAR(100) NOT NULL,
    curso VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);
```
**Tabela de Usuários**
```CREATE TABLE usuario (
    id BIGINT NOT NULL AUTO_INCREMENT,
    login VARCHAR(100) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
```



## Endpoints da API
**Autenticação**
- POST /login: Autentica um usuário e retorna um token JWT.

**Tópicos**
- GET /topicos: Lista todos os tópicos.
- GET /topicos/{id}: Detalha um tópico específico.
- POST /topicos: Cria um novo tópico.
- PUT /topicos/{id}: Atualiza um tópico existente.
- DELETE /topicos/{id}: Exclui um tópico.

## Testando a API

Use Postman ou Insomnia para testar os endpoints da API.
Certifique-se de incluir o token JWT nas requisições

