![GitHub language count](https://img.shields.io/github/languages/count/SiqueiraAndre/msr-algalog?style=for-the-badge)
![GitHub forks](https://img.shields.io/github/forks/SiqueiraAndre/msr-algalog?style=for-the-badge)
![Bitbucket open issues](https://img.shields.io/bitbucket/issues/SiqueiraAndre/msr-algalog?style=for-the-badge)
![Bitbucket open pull requests](https://img.shields.io/bitbucket/pr-raw/SiqueiraAndre/msr-algalog?style=for-the-badge)

![demonstração](https://cafe.algaworks.com/wp-content/uploads/2021/04/MSR-300px.png)

> A algalog-api é uma api de logistica criado durante o evento Mergulho Spring Rest promovido pela AlgaWorks.

## 📝 TODO

- [ ] Padrão DTO no Cliente
- [ ] Cancelamento de uma Entrega 

## ✏️ Modelo conceitual

![modelo-conceitual](https://github.com/SiqueiraAndre/msr-algalog/blob/master/model.png)

## 💻 Pré-requisitos

* Java 11 ou superior
* Maven
* IDE favorita

## 💻 Tecnologias

* Java 11
* Spring 
  * Spring Boot
  * Hibernate Validation
  * DevTools
* Lombok
* MySQL 
* Flyway
* ModelMapper

## 🚀 Como executar o projeto
* Necessário ter o WAMP 

```bash
# Entrar no diretório do projeto
$ cd algalog-api

No terminal, digite o comando:
```bash
./mvnw spring-boot:run 
```
Após, utilize os links:
```bash
# endpoint clientes
http://localhost:8080/api/v1/clients

# endpoint entregas
http://localhost:8080/api/v1/deliveries

# endpoint ocorrências
http://localhost:8080/api/v1/deliveries/{deliveryId}/ocurrences
```

## Sobre
Desenvolvimento de uma API REST de gerenciamento de entregas durante o evento Mergulho Spring REST da [AlgaWorks](https://www.algaworks.com "Site da AlgaWorks").
