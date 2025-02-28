# Workshop Spring Boot com MongoDB

Este repositório contém um projeto prático de Spring Boot utilizando MongoDB, o qual, aborda conceitos essenciais para o desenvolvimento de aplicações com banco de dados NoSQL.

## ✨ Tecnologias Utilizadas

- Java 21

- Spring Boot 3

- Spring Data MongoDB

- MongoDB

## 🔧 Configuração do Ambiente

Antes de executar o projeto, certifique-se de ter instalado:

Java 21

Maven (se não estiver usando um gerenciador como o Spring Boot integrado ao IDE)

MongoDB 

## 🚀 Executando o Projeto

1. Clonar o Repositório

git clone https://github.com/gustavofersantos/workshop-springboot-mongodb.git

2. Configurar o MongoDB

Se já tiver o MongoDB instalado localmente, ele precisará estar rodando na porta padrão (27017).

3. Executar a Aplicação

Com o MongoDB configurado, execute o seguinte comando para iniciar o projeto:

mvn spring-boot:run

Caso estiver usando uma IDE como IntelliJ, Eclipse ou VS Code, execute a classe WorkshopSpringbootMongodbApplication.

## 🔍 Endpoints Disponíveis

Após iniciar a aplicação, os seguintes endpoints REST estarão acessíveis:



- Usuários

Listar todos os usuários: GET /users

Buscar por ID: GET /users/id:{id}

Buscar por nome: GET /users/name:{name}

Criar um novo usuário: POST /users

Atualizar um usuário: PUT /users/id:{id}

Deletar um usuário por ID: DELETE /users/id:{id}

Deletar um usuário por nome: DELETE /users/name:{name}

Buscar posts de um usuário: GET /users/id:{id}/posts



- Posts

Buscar post por ID: GET /posts/id:{id}

Buscar posts por título: GET /posts/titlesearch?text={texto}

Buscar posts com filtro avançado: GET /posts/fullsearch?text={texto}&minDate={data_min}&maxDate={data_max}

-- Para testar as requisições, você pode utilizar o Postman ou a ferramenta Insomnia.

---

### Desenvolvido por Gustavo F. Santos durante curso de Java Completo do professor Nelio Alves.
