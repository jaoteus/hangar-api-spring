# 🚗 Hangar API

## Introdução

This API allows the developer to add, update, read and delete an aircraft or Hangar from the database. I created this AṔI just for studies and to test knowledge, it is likely that over time I will modify the code and consequently update this README.

## 🎯 Objetivos

- Desenvolver uma API REST Java.

## 📚 Índice

- [Recursos](#recursos)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Endpoints](#endpoints)
    - [Consultar todos os carros](#consultar-todos-os-carros)
    - [Cadastrar um novo carro](#cadastrar-um-novo-carro)
    - [Alterar a placa de um carro](#alterar-a-placa-de-um-carro)
- [Como Executar](#como-executar)
- [Licença](#licença)

## 🛠 Recursos

- Consultar todas as aeronaves.
- Consultar uma aeronave.
- Atualizar uma aeronave.
- Cadastrar uma nova aeronave.
- Deletar uma aeronave.
- Consultar todos os hangares.
- Consultar um hangar.
- Atualizar um hangar.
- Deletar um hangar.
- Adicionar uma aeronave no hangar.
- Remover uma aeronave do hangar.

## 🎧 Tecnologias Utilizadas

- Java 17
- Spring Boot 3.3.0
- PostgreSQL
- Maven
- Spring Web
- Hibernate
- Docker
- Git


## 📂 Estrutura do Projeto

A `divisão` de camadas do projeto será:

- `config`
- `Controller`
- `Repository`
- `Model`

## 🔍 Endpoints

### Consultar todas as aeronaves

- **Rota:** `GET /aircrafts`
- **Descrição:** Retorna uma lista com todas as aeronaves adicionadas.

<!-- ![resultado rota get](https://github.com/lucasgm18/oficina-api/assets/127359287/ce05c88e-01e4-4d65-9dd4-d3d47b8cb211) -->
![get all aircrafts](https://github.com/jaoteus/hangar-api-spring/assets/128613422/1222473e-3bab-4d04-bd7b-1cab33f75a42)

---

### Consultar uma aeronave por id

- **Rota:** `GET /aircrafts/{id}`
- **Descrição:** Retorna uma aeronave.
- **Exemplo de Cadastro:**

<!-- ![rota post swagger](https://github.com/lucasgm18/oficina-api/assets/127359287/0c43005b-d6a3-4667-9973-c7011afbcbd4) -->
![Screenshot from 2024-05-30 19-50-38](https://github.com/jaoteus/hangar-api-spring/assets/128613422/a1d19512-7bdd-49ed-aad2-40916020d09e)

---

### Atualizar uma aeronave por id

- **Rota:** `PUT /aircrafts/{id}`
- **Descrição:** Atualiza os campos da aeronave pelo id.
- **Parâmetros de Rota:**
    - `vin`: O número de identificação do veículo.
- **Exemplo de Alteração:**

<!-- ![ROTA PUT PT1](https://github.com/lucasgm18/oficina-api/assets/127359287/cc9ce197-4a32-401f-a73e-9c1c44dfff09)

![ROTA PUT PT2](https://github.com/lucasgm18/oficina-api/assets/127359287/62c262c0-5766-4aa8-933b-dcdffff1ec14) -->

---

### Deletar uma aeronave por id

- **Rota:** `DELETE /aircrafts/{id}`
- **Descrição:** Deleta uma aeronave pelo id.

---

### Consultar todos os hangares

- **Rota:** `GET /hangars`
- **Descrição:** Retorna uma lista com todos os hangares adicionados juntamente com todas as aeronaves que possuem no hangar.
<!-- 
![resultado rota get](https://github.com/lucasgm18/oficina-api/assets/127359287/ce05c88e-01e4-4d65-9dd4-d3d47b8cb211) -->

---

### Consultar um hangar por id

- **Rota:** `GET /hangars/{id}`
- **Descrição:** Retorna um hangar juntamente com todas as aeronaves que possuem no hangar.

<!-- ![rota post swagger](https://github.com/lucasgm18/oficina-api/assets/127359287/0c43005b-d6a3-4667-9973-c7011afbcbd4) -->


---

### Atualizar um hangar por id

- **Rota:** `PUT /hangars/{id}`
- **Descrição:** Atualiza os campos do hangar pelo id.
- **Parâmetros de Rota:**
    - `vin`: O número de identificação do veículo.
- **Exemplo de Alteração:**

<!-- ![ROTA PUT PT1](https://github.com/lucasgm18/oficina-api/assets/127359287/cc9ce197-4a32-401f-a73e-9c1c44dfff09)

![ROTA PUT PT2](https://github.com/lucasgm18/oficina-api/assets/127359287/62c262c0-5766-4aa8-933b-dcdffff1ec14) -->


---

### Deletar um hangar por id

- **Rota:** `DELETE /hangars/{id}`
- **Descrição:** Deleta um hangar pelo id.

---

### Adicionar uma aeronave no hangar

- **Rota:** `POST /hangars/{id}/aircrafts/{id}`
- **Descrição:** Adiciona uma aeronave em um hangar.

---

### Remover uma aeronave do hangar

- **Rota:** `DELETE /hangars/{id}/aircrafts/{id}`
- **Descrição:** Remove uma aeronave do hangar.

---

## 🚀 Como Executar

Clone o repositório:
```sh
git clone https://github.com/jaoteus/hangar-api-spring.git
```

Navegue até o diretório do projeto:
```sh
cd hangarapi/
```
Agora suba o container com o Postgres com o seguinte comando (no Linux):
```sh
sudo docker-compose up -d
```
O arquivo `docker-compose.yml` já está no projeto.

Agora compile e execute a aplicação:

```sh
mvn clean install
mvn spring-boot:run
```


### 📄 Licença
Este projeto está licenciado sob a Licença MIT. Veja o arquivo LICENSE para mais detalais.

---
