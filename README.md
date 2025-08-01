# 📆 Agendador de Tarefas – Sistema Completo

Sistema completo com **cadastro de usuários**, **agendamento de tarefas** e **envio de notificações assíncronas por e-mail**, estruturado com arquitetura de microsserviços e orquestração via BFF (Backend for Frontend).

---

## 🧠 Visão Geral

Este projeto foi criado com foco em praticar conceitos avançados de desenvolvimento backend com Java e Spring Boot, incluindo autenticação com JWT, deploy com Docker, CI/CD com GitHub Actions e serviços independentes que se comunicam entre si.

O sistema conta com:

- API de **cadastro e autenticação de usuários**
- API de **agendamento e gerenciamento de tarefas**
- Serviço assíncrono de **notificações por e-mail**
- Orquestração via **BFF (Backend for Frontend)** para consumo centralizado dos serviços

---

## 🏗️ Arquitetura

```
Usuário (frontend)
      ↓
     BFF
 ┌────────────┐
 │ /auth      │ → Serviço de autenticação (JWT)
 │ /tasks     │ → Serviço de agendamento de tarefas
 │ /notify    │ → Serviço de notificações por e-mail
 └────────────┘
```

Cada serviço é executado de forma independente, seguindo os princípios de microsserviços, e se comunica com o BFF, que funciona como ponto central de integração.

---

## 🔧 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**, Spring Security, Spring Web, Spring Data JPA
- **JWT** para autenticação segura
- **PostgreSQL** e **MongoDB**
- **Docker** e Docker Compose
- **GitHub Actions** para CI/CD
- **Swagger** para documentação das APIs
- **AWS (S3 e Lambda)** para simulação de serviços cloud
- **JUnit e Mockito** para testes

---

## 🧪 Como executar o projeto

1. **Clone o repositório**

```bash
git clone https://github.com/dev-Leirbag/agendador-tarefas.git
cd agendador-tarefas
```

2. **Configure variáveis de ambiente**

Crie arquivos `.env` ou `application.properties` para cada serviço (`auth`, `tasks`, `notify`, `bff`) com configurações específicas de banco, porta e tokens.

3. **Execute com Docker Compose**

```bash
docker-compose up --build
```

4. **Acesse os endpoints**

- Swagger do BFF: `http://localhost:8080/swagger-ui.html`
- Autenticação: `/auth`
- Tarefas: `/tasks`
- Notificações: `/notify`

---

## 📂 Estrutura dos diretórios

```
agendador-tarefas/
│
├── auth-service/         → Cadastro e login de usuários
├── task-service/         → Agendamento, edição e exclusão de tarefas
├── notification-service/ → Serviço assíncrono de envio de e-mails
├── bff/                  → Backend for Frontend que orquestra as requisições
├── docker-compose.yml    → Orquestração dos serviços
└── README.md             → Documentação do projeto
```

---

## 🚀 Funcionalidades

✔️ Cadastro de usuários com senha criptografada  
✔️ Login com geração de token JWT  
✔️ Agendamento de tarefas com data, título e descrição  
✔️ Notificações automáticas por e-mail em horário agendado  
✔️ Integração centralizada com segurança via BFF  
✔️ CI/CD com GitHub Actions  
✔️ Deploy local com Docker e configuração cloud com AWS

---

## 💡 Próximas melhorias

- Dashboard com métricas e histórico de notificações  
- Tela de frontend com React ou Angular (em andamento)  
- Deploy final em ambiente de produção (AWS EC2 ou Render)

---

## 🤝 Contribuição

Sinta-se à vontade para abrir issues, propor melhorias ou sugerir correções. Este projeto é um laboratório contínuo de boas práticas e arquitetura escalável.

---

## 🧑‍💻 Autor

**Gabriel Alves Ferreira**  
[LinkedIn](https://www.linkedin.com/in/gabriel-alves-profile/)  
[GitHub](https://github.com/dev-Leirbag)
