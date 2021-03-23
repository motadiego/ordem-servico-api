# ordem-servico-api

<h1 align="center">
    <img alt="Orbit Trip" src="./assets/banner.jpg" width="50%"/>
    <br>
    API REST Spring-Boot
</h1>

<h4 align="center">
  API REST para cadastro e consulta de clientes e ordens de serviços.
</h4>

## Descrição

- Este projeto foi desenvolvido em [Java](https://www.java.com/pt-BR/download/help/whatis_java.html) com [Spring-Boot](https://spring.io/projects/spring-boot) para fins de capacitação pessoal.

## Como Usar

Para clonar e compilar este projeto, você precisará [Git](https://git-scm.com),
[Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) ou superior instalado em seu
computador:

```bash
# Clone this repository
$ git clone https://github.com/motadiego/ordem-servico-api.git
```

## Banco de Dados

- Neste projeto foi utilizado o banco de dados [PostgreSQL](https://www.postgresql.org/), as definições podem ser refatoradas no arquivo <i>application.properties</i> no diretório resources.
- Para compilar o projeto, é necessário ter criado a base de dados antes, neste projeto foi criado como exemplo o 'ordem-servico'.

## Descrição do Projeto

- Este projeto é uma API REST, desenvolvida em Java com Spring-Boot, tendo como base o cadastro e leitura de Clientes e suas Ordens de serviços.
- Para realizar a comunicação de uma aplicação front-end ou algum sistema de testes dos métodos HTTP, foi configurada uma rota que pode ser acessada pelo link: http://localhost:8080, após startar o projeto.
- Para cadastrar um novo cliente, foi configurado o método HTTP POST, na rota '/api/clientes', http://localhost:8080/api/clientes.
- Para listar os clientes cadastrados, foi configurado o método HTTP GET, na rota '/api/clientes', http://localhost:8080/api/clientes.
- Para listar um cliente específico cadastrado, foi configurado o método HTTP GET, na rota 'api/clientes/${id}', http://localhost:8080/api/clientes/${id}, sendo necessário informar por parâmetro o ID do cliente esperado.
- Para editar um cliente cadastrado, foi configurado o método HTTP PUT, na rota 'api/clientes', http://localhost:8080/api/clientes, sendo necessário passar o objeto cliente com todas as informações, principalmente o ID, para editar o cliente.
- Para apagar um cliente cadastrado, foi configurado o método HTTP DELETE, na rota 'api/clientes', http://localhost:8080/api/clientes, sendo necessário passar o ID, para deletar o cliente.

- Para cadastrar uma ordem de serviço, foi configurado o método HTTP POST, na rota '/api/ordemservico', http://localhost:8080/api/ordemservico.
- Para listar as ordens de serviços cadastradas, foi configurado o método HTTP GET, na rota '/api/ordemservico', http://localhost:8080/api/ordemservico.
- Para listar uma ordem de serviço específica cadastrada, foi configurado o método HTTP GET, na rota 'api/ordemservico/${id}', http://localhost:8080/api/ordemservico/${id}, sendo necessário informar por parâmetro o ID da ordem de serviço esperada.
- Para apagar uma ordem de serviço cadastrada, foi configurado o método HTTP DELETE, na rota 'api/ordemservico', http://localhost:8080/api/ordemservico, sendo necessário passar o ID, para deletar a ordem de serviço.

- Foi configurado um <strong>repository</strong> com o método <strong>findByCpf()</strong> e <strong>findByEmail()</strong> o qual é utilizado na rota de cadastro de clientes, para as demais rotas foi utilizado os próprios métodos do Spring-Boot configurados em <i>JpaRepository</i>.

- Na model foi utilizado <strong>lombok</strong> para definir os métos get, set, modificadores de acesso, os construtores e definição da tabela a ser criada no banco.

- Para documentação da API foi utilizado o <strong>Swagger</strong>, que pode ser acessado pelo link: http://localhost:8080/swagger-ui.html, após startar o projeto.

## Technologies

Este projeto foi desenvolvido com a finalidade de capacitação pessoal, utilizando as seguintes tecnologias:

- [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Swagger](https://swagger.io/)
- [Lombok](https://projectlombok.org/)
- [PostgreSQL](https://www.postgresql.org/)
- [Eclipse](https://www.eclipse.org/downloads/)

---

Desenvolvido por [Diego Alves Marinho da Mota (https://www.linkedin.com/in/diego-alves-b3349819a/)
