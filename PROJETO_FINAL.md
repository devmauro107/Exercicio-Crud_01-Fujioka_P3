# IESPFLIX - Projeto BackEnd

## 📌 Descrição
Este projeto tem como objetivo desenvolver uma **API REST** para o sistema **IESPFLIX**, utilizando:
- Spring Boot 3.x
- Spring Web (APIs REST)
- Spring Data JPA
- Bean Validation (incluindo Custom Validators)
- Lombok
- Flyway (migrations)
- PostgreSQL ou H2 Database
- SpringDoc OpenAPI (Swagger UI)

---

## 🚀 Objetivos de Aprendizado
- Modelagem de banco de dados com JPA/Hibernate.
- Criação de APIs REST com Spring Web.
- Uso de **Bean Validation** e implementação de **Custom Validators**.
- Consultas personalizadas com **JPQL**.
- Redução de boilerplate com **Lombok**.
- Padronização de respostas de erro (`application/problem+json`).
- Geração automática de documentação com **SpringDoc OpenAPI**.

---

## ⚙️ Requisitos
- Java 17 (ou superior)
- Maven 3.9+
- PostgreSQL 15+ (produção)
- H2 Database (desenvolvimento)

---

## 🗂️ Estrutura do Projeto
- `src/main/java` → código da aplicação
- `src/main/resources` → `application.yml` ou `application.properties`, migrations do Flyway
- `src/test/java` → testes automatizados

---

## 🛠️ Configuração do Banco

### Exemplo usando **PostgreSQL** (application.yml)
```yaml
spring:
  application:
    name: techback
  datasource:
    url: jdbc:postgresql://localhost:5432/iespflx
    username: seu_usuario
    password: sua_senha
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: validate
    show-sql: true
    properties:
      hibernate:
        format_sql: true
  flyway:
    enabled: true
```

### Exemplo usando **H2** (application.properties)
```properties
spring.application.name=techback

# H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2

# Datasource
spring.datasource.url=jdbc:h2:file:~/teckback
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto=update

# JPA specific configs
spring.jpa.properties.hibernate.show_sql=false
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.use_sql=true
```

---

## ▶️ Executando o Projeto
```bash
# Rodar a aplicação
mvn spring-boot:run

# Compilar e empacotar
mvn clean package
```

A API ficará disponível em:  
👉 `http://localhost:8080`

---

## 📚 Documentação da API
Este projeto utiliza **SpringDoc OpenAPI** para geração automática da documentação.

Após iniciar a aplicação, acesse:
- **Swagger UI**: 👉 `http://localhost:8080/swagger-ui.html`
- **OpenAPI JSON**: 👉 `http://localhost:8080/v3/api-docs`

---

## 📚 Endpoints Esperados
- `GET /api/v1/usuarios`
- `GET /api/v1/conteudos?tipo=FILME&genero=Aventura`
- `POST /api/v1/favoritos`
- `GET /api/v1/planos`
- `POST /api/v1/assinaturas`

*(Detalhes completos no documento de especificação)*

---

## 📝 Atividades Guiadas
1. Criar o banco e entidades (`usuarios`, `conteudo`, `favorito`, `plano`, `assinatura`, `metodo_pagamento`).
2. Implementar APIs REST de `conteudo` com filtros e ordenação alfabética.
3. Implementar endpoints de `favorito` e `assinatura`.
4. Implementar **4 consultas JPQL** sugeridas na especificação.
5. Criar ao menos **1 Custom Validator** (ex.: CPF/CNPJ ou senha forte).
6. Aplicar **Lombok** em todas as entidades.
7. Tratar erros globais com resposta no formato **RFC 7807**.

---

## 🎯 Plus (opcional)
- Autenticação com JWT.
- Integração com API pública de filmes (TMDB/OMDb).
- Testes unitários e de integração com JUnit.

---

## 👨‍🏫 Professor
Rodrigo Fujioka  
Disciplina: **BackEnd - Tecnologias Web**


---

## 🔧 Guia de Setup (Banco e Configurações)
Para **todas as combinações** de configuração (YAML e properties, PostgreSQL e H2) **com Flyway**, consulte o guia consolidado:  
👉 [SETUP.md](sandbox:/mnt/data/SETUP.md)
