# FluffyNow - Registro de pontos

<hr>

## Conceitos

Projeto FullStack para criação de um sistema web para persistência de dados relacionados a um sistema de registro de ponto de funcionários. O sistema consiste em um banco de dados (PostgreSQL) integrado via web com API (SpringBoot), que possui interface para cadastro (Angular).

## Banco de Dados

Inicialmente montou-se um modelo de negócio para a solução implementada. Levou-se em consideração um modelo de armazenamento relacional, em que algumas tabelas são compartilhadas entre as empresas, como forma de balancear a distribuição e reaproveitar dados. Segue o modelo criado: 

![Modelo de dados](documentation/data_model/uml_data_model.png)

Foi utilizado SGBD PostgreSQL para persistência dos dados 

### Métodos
Requisições para a API devem seguir os padrões:

| Método | Descrição |
|---|---|
| `GET` | Retorna informações de um ou mais registros. |
| `POST` | Utilizado para criar um novo registro. |
| `PUT` | Atualiza dados de um registro ou altera sua situação. |
| `DELETE` | Remove um registro do sistema. |

## Banco de Dados

Neste projeto optou-se pela gestão de dados utilizando PostgreSQL. O modelo de dados foram implementados em linguagem SQl, e acrescidos em um script .sql. Este script pode ser acionado por meio de um programa de implementação em Python para sua instalação. 

As tabelas geradas são: 

* Contato. 
* Endereço. 
* Funcionário. 
* Guia de Atendimento.
* Hospital. 
* Paciente. 

As tabelas de Pacientes e Funcionários compartilham de informações armazenadas para Contato e Endereço.

## Testes

A principio não forma implementados testes automatizados para o projeto, ficando a cargo somente de testes diretos realizados utilizando dados de amostra. Requisições testadas com o Postman. 



 