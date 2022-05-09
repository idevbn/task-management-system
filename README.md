# Desafio Backend Java - SOGO Tecnologia

<h3>Repositório com a solução do desafio backend em Java da SOGO.</h3>

<br>

## Tecnologias

<div align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white">
  <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
  <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white">
</div>

<br>

## Executando o Projeto:

1. Requisitos:

Para rodar este projeto localmente é necessário ter instalado: **[Java 8](https://openjdk.java.net/install/)**, **[Maven](https://maven.apache.org/)** e o banco de dados relacional **[Postgres](https://www.postgresql.org/download/)**.

2. Clonando este repositório:

```sh
  $ git clone https://github.com/idevbn/task-management-system.git
```

3. Executando o projeto localmente:

```sh
  # Gerando o arquivo .jar da aplicação
  $ mvn clean install -Dskiptests

  # Executar na pasta raiz da aplicação
  $ java -jar -Dspring.profiles.active=localdebug task-management-system-0.0.1-SNAPSHOT.jar
```
