# Projeto_Jobfy
## Sistema de Gerenciamento de Empresas e Colaboradores

Este projeto é um sistema de gerenciamento de empresas e colaboradores, construído com **Java** e **Spring Boot**, utilizando o **PostgreSQL** como banco de dados. O sistema implementa as operações **CRUD** (Criar, Ler, Atualizar, Deletar) para oferecer uma interface completa e interativa para o gerenciamento de empresas e seus colaboradores.

Cada empresa pode ter vários colaboradores, mas cada colaborador está associado a apenas uma empresa.

## Tecnologias Utilizadas
- **Java**: Linguagem de programação poderosa e orientada a objetos, escolhida pela sua robustez e portabilidade.
- **Spring Boot**: Framework que facilita a criação de aplicações stand-alone baseadas em Spring, simplificando a configuração e o deployment.
- **PostgreSQL**: Sistema de gerenciamento de banco de dados relacional, conhecido pela sua confiabilidade e recursos avançados.
- **Postman**: Ferramenta de desenvolvimento API que facilita a criação, teste e gerenciamento de APIs.

## Funcionalidades
- **Criação de Empresas e Colaboradores**: Adicione novas empresas e colaboradores ao banco de dados com facilidade.
- **Leitura de Empresas e Colaboradores**: Visualize uma lista de todas as empresas e colaboradores disponíveis com detalhes completos.
- **Atualização de Empresas e Colaboradores**: Modifique as informações das empresas e colaboradores existentes conforme necessário.
- **Deleção de Empresas e Colaboradores**: Remova empresas e colaboradores do banco de dados de forma segura e eficaz.

## Configuração do Banco de Dados
Para configurar o banco de dados PostgreSQL, siga os passos abaixo:
1. Crie um banco de dados no PostgreSQL.
2. Referencie o banco de dados criado no arquivo `application.properties`, localizado em `src\main\resources\application.properties`.

## Como Executar
Para executar este projeto localmente, siga os passos abaixo:
1. Clone o repositório para sua máquina local.
2. Configure o banco de dados PostgreSQL conforme as instruções acima.
3. Coloque os métodos no Postman e faça as requisições.
4. Execute o projeto.
