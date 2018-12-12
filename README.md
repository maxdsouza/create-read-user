# Basic User System

Sistema básico de cadastro e listagem de usuários, também contém REST Controller onde pode ser desenvolvido qualquer Frontend através da API disponibilizada.

## 1. Requisitos e Configurações

Para executar o sistema é necessária a instalação das seguintes ferramentas:

    1. Java SE Development Kit 8u191
    2. Apache Maven 3.6.0
    
  - [Download Java SE Development Kit 8u191](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
  - [Download Apache Maven 3.6.0](https://maven.apache.org/download.cgi)

## 2. Executando o Sistema

Após baixar o sistema, baixar e instalar as ferramentas necessárias, para executá-lo é necessário rodar o seguinte comando dentro da pasta raiz do sistema:

```sh
$ mvn spring-boot:run
```

Para acessar o sistema digite a seguinte URL em seu navegador de preferência:

```sh
http://localhost:8080
```

## 3. URLs REST

Ferramenta recomendada para execução das requisições REST:

    - Postman

  - [Download Postman](https://www.getpostman.com/apps)

Segue as URLs para acesso ao controlador REST:

```sh
Lista todos os usuários cadastrados (requisição GET):
http://localhost:8080/users

Cadastro o usuário com preenchimento do JSON (requisição POST):
http://localhost:8080/register

Exemplo de preenchimento do JSON:

{
  "name":"Teste",
  "email":"teste@teste.com",
  "password":"12345678"
}
```
## 4. Swagger API Documentation

Ferramenta que faz o mapeamento no sistema das APIs, disponibizando os recursos e suas URLs, demonstrando quais recursos o sistema contém:

Segue as URLs para acesso ao Swagger API Documentation:

```sh
http://localhost:8080/swagger-ui.html
```