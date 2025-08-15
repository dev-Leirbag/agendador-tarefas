# 📆 Agendador de Tarefas – Microserviço

Este repositório é responsável por criar, listar, atualizar e excluir tarefas de usuários previamente cadastrados no sistema.

ℹ️ Este não é o sistema completo. Ele funciona em conjunto com outros microsserviços:

[Cadastro/Autenticação de Usuários](https://github.com/dev-Leirbag/usuario)

[Notificação por E-mail](https://github.com/dev-Leirbag/notificacao)

[BFF (Backend for Frontend)](https://github.com/dev-Leirbag/bff-agendador-tarefas)

## 🧠 Visão Geral

O Task Service recebe requisições do BFF e mantém o ciclo de vida das tarefas no banco de dados.
Cada tarefa pode conter título, descrição, data e hora de execução, e status.

🔧 Tecnologias Utilizadas

Java 17

Spring Boot (Spring Web, Spring Data JPA)

PostgreSQL

Docker

Swagger para documentação

JUnit e Mockito para testes

## 🧪 Como executar este microserviço

- Clone o repositório

      git clone https://github.com/dev-Leirbag/agendador-tarefas.git

- Configure o application.properties

      spring.datasource.url=jdbc:postgresql://localhost:5432/taskdb
      spring.datasource.username=seu_usuario
      spring.datasource.password=sua_senha
      usuario.url=localhost:8080
      server.port=8081

- Execute com Maven ou Docker

- Com Maven:

      mvn spring-boot:run

- Com Docker(Não Obrigatorio para o funcionamento):

      docker build -t task-service .
      docker run -p 8081:8081 task-service

- Acesse a documentação Swagger

      http://localhost:8081/swagger-ui.html

🚀 Funcionalidades

✔️ Criar tarefas
✔️ Listar tarefas
✔️ Atualizar tarefas
✔️ Excluir tarefas

🔗 Outros Microsserviços do Sistema

Auth Service (Cadastro e Login de Usuários) → [Repositório](https://github.com/dev-Leirbag/usuario)

Notification Service (Envio de E-mails) → [Repositório](https://github.com/dev-Leirbag/notificacao)

BFF (Integração e Orquestração) → [Repositório](https://github.com/dev-Leirbag/bff-agendador-tarefas)

🧑‍💻 Autor
**Gabriel Alves Ferreira**

[LinkedIn](https://www.linkedin.com/in/gabriel-alves-profile/)
