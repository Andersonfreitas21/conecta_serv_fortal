# Conecta Serv Fortal

## Descrição

O Conecta Serv Fortal é uma aplicação web que visa facilitar a conexão entre consumidores e profissionais de serviços domésticos na região metropolitana de Fortaleza. A plataforma permite que consumidores encontrem profissionais qualificados e confiáveis para uma variedade de serviços, como limpeza, reparos, manutenção e muito mais.

## Tecnologias Utilizadas

A aplicação é desenvolvida utilizando as seguintes tecnologias:

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![React](https://img.shields.io/badge/react-%2320232a.svg?style=for-the-badge&logo=react&logoColor=%2361DAFB)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)

## Funcionalidades

- Funcionalidades do Aplicativo:
- Cadastro de consumidores e profissionais.
- Busca por categoria de serviço e localização.
- Avaliações e comentários para profissionais.
- Sistema de pagamento seguro.
- Chat para comunicação direta.
- Agendamento de serviços.

## Endpoints

A API da aplicação oferece os seguintes endpoints:

### Cadastro de Usuários:

#### Retorna todos os itens

#### Consumidores:
```http
POST /api/consumidores: Cria um novo consumidor.
```
```http
GET /api/consumidores/{id}: Retorna informações de um consumidor específico.
```

#### Profissionais:
```http
POST /api/profissionais: Cria um novo profissional.
```
```http
GET /api/profissionais/{id}: Retorna informações de um profissional específico.
```

### Busca e Filtros:

#### Busca Avançada:
```http
GET /api/servicos: Busca serviços com base em filtros de categoria, localização e disponibilidade.
```

#### Filtros de Pesquisa:
```http
GET /api/servicos: Filtra serviços por avaliação, proximidade, preço e disponibilidade.
```

### Perfis de Usuários:

#### Páginas de Perfil:
```http
GET /api/consumidores/{id} ou /api/profissionais/{id}: Retorna informações detalhadas de um perfil de consumidor ou profissional.
```

### Sistema de Avaliações:

#### Avaliações Bidirecionais:
```http
POST /api/avaliacoes: Cria uma nova avaliação.
```

### Agendamento de Serviços:

#### Calendário de Disponibilidade:
```http
POST /api/disponibilidades/{id_profissional}: Define a disponibilidade de um profissional.
```

### Sistema de Pagamento:

#### Pagamento Seguro:
- Integração com plataforma de pagamento online.

### Notificações:

#### Alertas e Atualizações:
- Implementação de sistema de notificações.

## Licença

Este projeto é licenciado sob a [Licença MIT](LICENSE).

