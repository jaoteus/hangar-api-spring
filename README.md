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
- **Exemplo:**

<!-- ![rota post swagger](https://github.com/lucasgm18/oficina-api/assets/127359287/0c43005b-d6a3-4667-9973-c7011afbcbd4) -->
![Screenshot from 2024-05-30 19-50-38](https://github.com/jaoteus/hangar-api-spring/assets/128613422/a1d19512-7bdd-49ed-aad2-40916020d09e)

---

### Adicionar uma aeronave

- **Rota:** `POST /aircrafts`
- **Descrição:** Adiciona uma nova aeronave.
- **Parâmetros de Rota:**
    - `vin`: O número de identificação do veículo.
- **Exemplo:**

<!-- ![ROTA PUT PT1](https://github.com/lucasgm18/oficina-api/assets/127359287/cc9ce197-4a32-401f-a73e-9c1c44dfff09)

![ROTA PUT PT2](https://github.com/lucasgm18/oficina-api/assets/127359287/62c262c0-5766-4aa8-933b-dcdffff1ec14) -->

![Screenshot from 2024-05-30 19-52-56](https://github.com/jaoteus/hangar-api-spring/assets/128613422/83b18ce3-4e15-4133-af0d-f69bb639da4b)

![Screenshot from 2024-05-30 19-53-45](https://github.com/jaoteus/hangar-api-spring/assets/128613422/3c7e98b4-baf3-4aa6-a315-c7846e33a8d4)

---

### Atualizar uma aeronave por id

- **Rota:** `PUT /aircrafts/{id}`
- **Descrição:** Atualiza os campos da aeronave pelo id.
- **Parâmetros de Rota:**
    - `vin`: O número de identificação do veículo.
- **Exemplo de Alteração:**

<!-- ![ROTA PUT PT1](https://github.com/lucasgm18/oficina-api/assets/127359287/cc9ce197-4a32-401f-a73e-9c1c44dfff09)

![ROTA PUT PT2](https://github.com/lucasgm18/oficina-api/assets/127359287/62c262c0-5766-4aa8-933b-dcdffff1ec14) -->

![Screenshot from 2024-05-30 19-54-58](https://github.com/jaoteus/hangar-api-spring/assets/128613422/9bf47567-c437-46dd-814b-8951ca94c92f)

![Screenshot from 2024-05-30 19-55-13](https://github.com/jaoteus/hangar-api-spring/assets/128613422/b10e412d-2d36-47a3-ad8c-76c66bf274c8)

---

### Deletar uma aeronave por id

- **Rota:** `DELETE /aircrafts/{id}`
- **Descrição:** Deleta uma aeronave pelo id.

![Screenshot from 2024-05-30 19-56-07](https://github.com/jaoteus/hangar-api-spring/assets/128613422/e514eae4-5fe4-479b-988c-3730603bb534)

![Screenshot from 2024-05-30 19-56-39](https://github.com/jaoteus/hangar-api-spring/assets/128613422/8c200d6e-cd52-40d5-8b17-1aad1f7a61ec)

---

### Consultar todos os hangares

- **Rota:** `GET /hangars`
- **Descrição:** Retorna uma lista com todos os hangares adicionados juntamente com todas as aeronaves que possuem no hangar.
<!-- 
![resultado rota get](https://github.com/lucasgm18/oficina-api/assets/127359287/ce05c88e-01e4-4d65-9dd4-d3d47b8cb211) -->

![Screenshot from 2024-05-30 19-59-27](https://github.com/jaoteus/hangar-api-spring/assets/128613422/aa318344-535d-4d2e-a5c7-d76b9c0390cc)

---

### Consultar um hangar por id

- **Rota:** `GET /hangars/{id}`
- **Descrição:** Retorna um hangar juntamente com todas as aeronaves que possuem no hangar.

<!-- ![rota post swagger](https://github.com/lucasgm18/oficina-api/assets/127359287/0c43005b-d6a3-4667-9973-c7011afbcbd4) -->

![Screenshot from 2024-05-30 19-59-39](https://github.com/jaoteus/hangar-api-spring/assets/128613422/4a277626-62aa-4e31-89e8-39feb496c1be)


---

### Adicionar um hangar

- **Rota:** `POST /hangars`
- **Descrição:** Adiciona um hangar.

![Screenshot from 2024-05-30 20-07-53](https://github.com/jaoteus/hangar-api-spring/assets/128613422/90c7d96c-1c1c-4ffd-957b-ee3b9ccc2c56)

![Screenshot from 2024-05-30 20-08-19](https://github.com/jaoteus/hangar-api-spring/assets/128613422/7bb25a20-2e0e-41fc-97e4-41f4a8059dde)

---

### Atualizar um hangar por id

- **Rota:** `PUT /hangars/{id}`
- **Descrição:** Atualiza os campos do hangar pelo id.
- **Parâmetros de Rota:**
    - `vin`: O número de identificação do veículo.
- **Exemplo de Alteração:**

<!-- ![ROTA PUT PT1](https://github.com/lucasgm18/oficina-api/assets/127359287/cc9ce197-4a32-401f-a73e-9c1c44dfff09)

![ROTA PUT PT2](https://github.com/lucasgm18/oficina-api/assets/127359287/62c262c0-5766-4aa8-933b-dcdffff1ec14) -->

![Screenshot from 2024-05-30 20-01-32](https://github.com/jaoteus/hangar-api-spring/assets/128613422/04b4bbce-fac2-4f31-8586-3b56e028387c)

![Screenshot from 2024-05-30 20-05-01](https://github.com/jaoteus/hangar-api-spring/assets/128613422/b5bc06a6-0374-4a9c-af58-ca96cc21d2d5)

---

### Deletar um hangar por id

- **Rota:** `DELETE /hangars/{id}`
- **Descrição:** Deleta um hangar pelo id.

![Screenshot from 2024-05-30 20-12-28](https://github.com/jaoteus/hangar-api-spring/assets/128613422/4e33210e-f81e-4f27-b77a-7e80b08f7bfa)

---


### Adicionar uma aeronave no hangar

- **Rota:** `POST /hangars/{id}/aircrafts/{id}`
- **Descrição:** Adiciona uma aeronave em um hangar.

![Screenshot from 2024-05-30 20-11-45](https://github.com/jaoteus/hangar-api-spring/assets/128613422/6514c028-d800-4069-bb55-9b4c3d6e0ec5)

![Screenshot from 2024-05-30 20-12-08](https://github.com/jaoteus/hangar-api-spring/assets/128613422/22e45fa5-01ea-4645-9cd7-dc8bb46b7484)

---

### Remover uma aeronave do hangar

- **Rota:** `DELETE /hangars/{id}/aircrafts/{id}`
- **Descrição:** Remove uma aeronave do hangar.

![Screenshot from 2024-05-30 20-12-28](https://github.com/jaoteus/hangar-api-spring/assets/128613422/167c784e-1ef8-4178-8214-1c0308993e97)

![Screenshot from 2024-05-30 20-12-43](https://github.com/jaoteus/hangar-api-spring/assets/128613422/8c68ec76-4dcc-4235-9d9c-97124cbeb588)


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
