# gerenciador-financeiro-transporte-carga

[![Build Status](https://travis-ci.org/codecentric/springboot-sample-app.svg?branch=master)](https://travis-ci.org/codecentric/springboot-sample-app)
[![Coverage Status](https://s3.amazonaws.com/assets.coveralls.io/badges/coveralls_90.svg)](https://s3.amazonaws.com/assets.coveralls.io/badges/coveralls_90.svg)

## Tecnologias

- [Spring Boot](https://projects.spring.io/spring-boot) é uma ferramenta que simplifica a configuração e execução de aplicações Java stand-alone,  com conceitos de dependências “starters”, auto configuração e servlet container embutidos é proporcionado uma grande produtividade desde o start-up da aplicação até sua ida a produção.
 
- [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html) é um framework já consolidado no mercado, que a partir da versão fornece mecanismos simplificados para a criação de APIs RESTful através de anotação, além disso, também possui recursos de serialização e deserialização de objetos de forma transparente 
 
- [Spring Data](http://projects.spring.io/spring-data/) é um framework que abstrai o acesso ao modelo de dados, independente a tecnologia de base de dados.

 
# Setup da aplicação (local)

## Pré-requisito

Antes de rodar a aplicação é preciso garantir que as seguintes dependências estejam corretamente instaladas:
```
Java 8
Maven 3.3.3 
```

## Instalação da aplicação

Primeiramente, faça o clone do repositório:
```
https://github.com/ednardomartins/gerenciador-financeiro-transporte-carga.git
```
Feito isso, acesse o projeto:
```
cd gerenciador-financeiro-transporte
```
É preciso compilar o código e baixar as dependências do projeto:
```
mvn clean package ou ./mvnw clean package
```
Finalizado esse passo, vamos iniciar a aplicação:
```
mvn spring-boot:run
```
Pronto. A aplicação está disponível em http://localhost:8080
```
Tomcat started on port(s): 8080 (http)
Started AppConfig in xxxx seconds (JVM running for xxxx)
```

# Setup da aplicação com docker

## Pré-requisito

Antes de rodar a aplicação é preciso garantir que as seguintes dependências estejam corretamente instaladas:

```
Docker 17.06.0 
```

## Gerar a imagem local (Não obrigatorio)

Esse passo nao é necessario ma vez que imagem esta no Docker Hub.

Se for o desejo gerarlocal basta executar executar :

```
mvn clean package dockerfile:build
```

## Instalação da aplicação


Executar container da aplicação

```
docker run -it \
    -p 8080:8080 \
    ednardo/custo-transporte-app 
```

Pronto. A aplicação está disponível em http://localhost:8080

# APIs

Segue abaixo as APIs disponíveis no projeto:

 - /calcularCustoTransporte (POST)
 - /veiculo (GET)
 
