# CentralDeErros 
Projeto final da aceleração Java da Codenation - Rest API, Spring Boot, Spring Security, OAuth2, Maven, Swagger, JPA 

#### Objetivo

Em projetos modernos é cada vez mais comum o uso de arquiteturas baseadas em serviços ou microsserviços. Nestes ambientes complexos, erros podem surgir em diferentes camadas da aplicação (backend, frontend, mobile, desktop) e mesmo em serviços distintos. Desta forma, é muito importante que os desenvolvedores possam centralizar todos os registros de erros em um local, de onde podem monitorar e tomar decisões mais acertadas. Neste projeto vamos implementar uma API Rest para centralizar registros de erros de aplicações.

Abaixo estão os requisitos desta API, o time terá total liberdade para tomar as decisões técnicas e de arquitetura da API, desde que atendam os requisitos abaixo.
#### API  
#### Tecnologia : 

Utilizar a tecnologia base da aceleração para o desenvolvimento (Exemplo: Java, Node.js)

#### Premissas : 

A API deve ser pensada para atender diretamente um front-end
Deve ser capaz de gravar os logs de erro em um banco de dados relacional
O acesso a ela deve ser permitido apenas por requisições que utilizem um token de acesso válido

#### Funcionalidades :

- Permite a autenticação do sistema que deseja utilizar a API gerando o Token de Acesso
- Pode ser acessado por multiplos sistemas
- Permite gravar registros de eventos de log salvando informações de Level(error, warning, info), Descrição do Evento, LOG do Evento, ORIGEM(Sistema ou Serviço que originou o evento), DATA(Data do evento), QUANTIDADE(Quantidade de Eventos de mesmo tipo)
- Permite a listagem dos eventos juntamente com a filtragem de eventos por qualquer parâmetro especificado acima
- Suporta Paginação
- Suporta Ordenação por diferentes tipos de atributos
- A consulta de listagem não retorna os LOGs dos Eventos
- Permite a busca de um evento por um ID, dessa maneira exibindo o LOG desse evento em específico

#### Informações para o client acessar a API :
- #### URI de acesso : https://central-de-erros-andrea.herokuapp.com/
- ###### usuario = centralErros
- ###### senha = erros123

