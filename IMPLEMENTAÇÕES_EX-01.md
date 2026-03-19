# 📋 CRUD de Funcionários

## ✅ Visão Geral
Este módulo implementa o gerenciamento de **Funcionários** dentro do sistema, permitindo operações de **CRUD** (Criar, 
Ler, Atualizar e Deletar).  
A estrutura foi projetada para ser clara, validada e consistente, garantindo confiabilidade nas operações.

---

## 📦 Estrutura Implementada
- **Entidade `Funcionario`**  
  Representa os dados do colaborador, com atributos como `id`, `nome`, `cargo` e demais campos conforme modelagem.  
  Inclui validações de obrigatoriedade e limites de tamanho.

- **Repositório `FuncionarioRepository`**  
  Interface que estende `JpaRepository`, fornecendo métodos prontos de persistência e consultas customizadas (ex.: listar ordenado por nome).

- **Serviço `FuncionarioService`**  
  Camada de lógica de negócio, responsável por coordenar operações de inclusão, listagem, busca, atualização e exclusão de funcionários.  
  Inclui tratamento de exceções com `ResourceNotFoundException`.

- **Controller `FuncionarioController`**  
  Exposição dos endpoints REST para interação com a API.  
  Métodos mapeados para:
    - `POST /funcionarios` → Criar funcionário
    - `GET /funcionarios` → Listar todos
    - `GET /funcionarios/{id}` → Buscar por ID
    - `PUT /funcionarios/{id}` → Atualizar
    - `DELETE /funcionarios/{id}` → Remover

- **DTO/Response (`ApiResponse` ou `FuncionarioDTO`)**  
  Padroniza as respostas da API, incluindo mensagem, dados e timestamp.

---

## ➕ Funcionalidades Adicionadas
- Validação de campos obrigatórios com **Bean Validation**.
- Documentação automática da API com **SpringDoc OpenAPI**.
- Testes de integração com **Testcontainers** (PostgreSQL).
- Uso de **Lombok** para reduzir código repetitivo.

---

## 🛠️ Correções e Melhorias
- Ajustes em validações para evitar inconsistências.
- Padronização de mensagens de resposta.
- Organização das camadas para maior legibilidade e manutenção.

---

## 🚀 Como Executar
1. Clone o repositório.
2. Configure o banco de dados (H2 para dev ou PostgreSQL para produção/testes).
3. Execute o projeto com:
   ```bash
   mvn spring-boot:run# 📋 CRUD de Funcionários

