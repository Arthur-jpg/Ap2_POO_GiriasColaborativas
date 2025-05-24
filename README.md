# Sistema de Gírias Colaborativas - Visão Geral

O sistema de gírias colaborativas é uma plataforma de crowdsourcing onde usuários podem cadastrar, explicar e votar em gírias brasileiras de diferentes regiões. O objetivo principal é criar um repositório colaborativo onde a comunidade define quais explicações são mais precisas através de votações.

## Conceito do Sistema

O sistema deve permitir que usuários cadastrados adicionem gírias brasileiras, forneçam explicações para elas, associem categorias e regiões onde são comumente usadas, e participem de um sistema de votação para determinar quais explicações são mais aceitas pela comunidade.

## Principais Entidades e Relacionamentos

### Usuário
Representa os participantes do sistema que podem criar conteúdo e votar.

- **Atributos**: identificador, nome, email, senha, data de cadastro, reputação
- **Ações**: cadastrar gírias, criar explicações, votar em conteúdos

### Gíria
A entidade central do sistema, representa uma expressão ou termo informal.

- **Atributos**: identificador, termo, data de criação, autor, status (ativo/inativo)
- **Relacionamentos**:
  - Criada por um Usuário (N:1)
  - Possui múltiplas Explicações (1:N)
  - Associada a várias Categorias (N:N)
  - Utilizada em diversas Regiões (N:N)
  - Recebe Votos dos usuários (1:N)
  - Mantém histórico de Edições (1:N)
### Explicação
Representa uma definição ou significado proposto para uma gíria.

- **Atributos**: identificador, texto, exemplos de uso, autor, data de criação
- **Relacionamentos**:
  - Pertence a uma Gíria (N:1)
  - Criada por um Usuário (N:1)
  - Recebe Votos dos usuários (1:N)
  - Mantém histórico de Edições (1:N)

### Categoria
Permite classificar as gírias por temas ou contextos.

- **Atributos**: identificador, nome, descrição
- **Relacionamentos**:
  - Associada a várias Gírias (N:N)
### Região
Representa uma região geográfica do Brasil.

- **Atributos**: identificador, nome, estado, descrição
- **Relacionamentos**:
  - Associada a várias Gírias (N:N)

### Voto
Representa a avaliação de um usuário sobre uma gíria ou explicação.

- **Atributos**: identificador, tipo (positivo/negativo), data
- **Relacionamentos**:
  - Feito por um Usuário (N:1)
  - Aplicado a um item Votável (N:1) - interface implementada por Gíria e Explicação
### Edição
Registra alterações feitas em conteúdos editáveis.

- **Atributos**: identificador, data, conteúdo anterior, novo conteúdo, editor
- **Relacionamentos**:
  - Feita por um Usuário (N:1)
  - Associada a um item Editável (N:1) - interface implementada por Gíria e Explicação

## Interfaces

### Votável
Interface implementada por entidades que podem receber votos.

- **Métodos**: getVotos(), adicionarVoto(), removerVoto()

### Editável
Interface implementada por entidades que podem ser editadas.

- **Métodos**: editar(), getHistoricoEdicoes()

## Classes Abstratas

### Conteúdo
Classe abstrata que serve como base para entidades criadas por usuários.

- **Atributos**: identificador, data de criação, autor, status
- **Métodos**: desativar(), reativar()

---

Este sistema demonstra vários conceitos de POO: herança (através de classes abstratas), interfaces, polimorfismo, encapsulamento, e diferentes tipos de relacionamentos (1:1, 1:N, N:N).