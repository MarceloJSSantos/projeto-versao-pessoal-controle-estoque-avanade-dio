# Projeto Controle de Estoque (Avanade/DIO) - VERSÃO PESSOAL
repositório com a VERSÃO PESSOAL do projeto prático "Controle de Estoque" das mentorias da AVANADE do Bootcamp "Code Anywhere" da [DIO](https://digitalinnovation.one/).

-----------------

- Feito até:
  - Projeto - Parte 1: Criando uma API REST com Spring Boot
  - Parte 2: Acessando e persistindo dados com SQL Server (Spring Data)
  - Parte 3: Incluindo segurança com JWT via Banco de Dados

------------

Neste projeto está sendo desenvolvido um sistema de controle de estoque c/ segurança via JWT



### Desenvolvimento

Foram desenvolvidas as seguintes tarefas:

* Configurações iniciais de um projeto com o Spring Boot Initialzr 

* Criação de modelo de dados para o mapeamento de entidades em bancos de dados

* Desenvolvimento de operações padrão arquitetural REST (GET, POST, PUT e DELETE)

  * Produto
  * Loja
  * Estoque
  * Usuário
  
* Desenvolvido as estruturas de segurança c/ JWT (Spring Security)

  

### Tecnologias e Dependências utilizadas

- **Java 11**
- **Maven** p/ gerenciamento de dependências
  - **Lombok**
  - **MapStruct**
  - **JWT Auth0**
- **Spring Boot (2.4.6)**
  - **Spring Web**
  - **Spring Data**
  - **Spring Devtools**
  - **Spring Security**
- **Git/GitHub** para versionamento do código
- **SQL Server** Banco de Dados
- **Docker** para os ambientes do BD



### Instalação e Execução

Para executar o projeto no terminal, digite o seguinte comando:

```shell script
mvn spring-boot:run 
```



### APIs p/ Consumo

#### Produtos

| VERBO  | URL                                        | CORPO                                                        |
| ------ | ------------------------------------------ | ------------------------------------------------------------ |
| GET    | http://localhost:8080/api/v1/produtos      | NÃO É NECESSÁRIO                                             |
| POST   | http://localhost:8080/api/v1/produtos      | {<br/>    "descricao": "Borracha - branca",<br/>    "validade": "9999-12-31",<br/>    "ean": "7890333534999",<br/>    "inativo": false<br/>} |
| PUT    | http://localhost:8080/api/v1/produtos      | {<br/>    "descricao": "Borracha - branca",<br/>    "validade": "9999-12-31",<br/>    "ean": "7890333534999",<br/>    "inativo": false<br/>} |
| DELETE | http://localhost:8080/api/v1/produtos/{id} | NÃO É NECESSÁRIO                                             |

#### Lojas

| VERBO  | URL                                     | CORPO                                                        |
| ------ | --------------------------------------- | ------------------------------------------------------------ |
| GET    | http://localhost:8080/api/v1/lojas      | NÃO É NECESSÁRIO                                             |
| POST   | http://localhost:8080/api/v1/lojas      | {<br/>    "nome": "Filial - Minas Gerais",<br/>    "inativo": false<br/>} |
| PUT    | http://localhost:8080/api/v1/lojas      | {<br/>    "nome": "Filial - Minas Gerais",<br/>    "inativo": false<br/>} |
| DELETE | http://localhost:8080/api/v1/lojas/{id} | NÃO É NECESSÁRIO                                             |

#### Estoque

| VERBO  | URL                                                          | CORPO                                                        |
| ------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| GET    | http://localhost:8080/api/v1/itensEstoque                    | NÃO É NECESSÁRIO                                             |
| POST   | http://localhost:8080/api/v1/itensEstoque                    | {<br/>    "nome": "Filial - Minas Gerais",<br/>    "inativo": false<br/>} |
| PUT    | http://localhost:8080/api/v1/itensEstoque                    | {<br/>    "nome": "Filial - Minas Gerais",<br/>    "inativo": false<br/>} |
| DELETE | http://localhost:8080/api/v1/itensEstoque/{idProduto}/{idLoja} | NÃO É NECESSÁRIO                                             |

#### Usuário

| VERBO  | URL                                     | CORPO                                                        |
| ------ | --------------------------------------- | ------------------------------------------------------------ |
| GET    | http://localhost:8080/api/v1/usuarios   | NÃO É NECESSÁRIO                                             |
| POST   | http://localhost:8080/api/v1/usuarios   | {<br/>    "nome": "Filial - Minas Gerais",<br/>    "inativo": false<br/>} |
| PUT    | http://localhost:8080/api/v1/usuarios   | {<br/>    "nome": "Filial - Minas Gerais",<br/>    "inativo": false<br/>} |
| DELETE | http://localhost:8080/api/v1/{userName} | NÃO É NECESSÁRIO                                             |

#### Diversos

| VERBO | URL                          | CORPO                                                        |
| ----- | ---------------------------- | ------------------------------------------------------------ |
| GET   | http://localhost:8080/status | NÃO É NECESSÁRIO                                             |
| POST  | http://localhost:8080/login  | {<br/>    "userName":"admin",<br/>    "senha":"123456"<br/>} |
