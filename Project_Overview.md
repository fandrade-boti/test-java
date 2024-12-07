# Projeto Test - Java

## Visão Geral
Spring Boot para criar um serviço RESTful.
estrutura básica para implementação utilizando uma
base de dados em memória  um `Map` para armazenar os produtos. 
Os cálculos das propriedades `inventory.quantity` e `isMarketable` serão feitos durante a recuperação do produto.

# Estrutura do Código
1. **Classe Produto** (`Product`):
  - Representa o produto, com métodos adicionais para calcular `inventory.quantity` e `isMarketable`.

2. **Controlador de Produto** (`ProductController`):
  - Fornece métodos para criação, atualização, recuperação e deleção de produtos.

3. **Classe Serviço de Produto** (`ProductService`):
  - Lida com a lógica de negócios e operações em memória.

4. **Classe Exceção** (`ProductAlreadyExistsException`):
  - Para tratar o caso onde um produto com o mesmo SKU já existe.

## Funcionalidades
Criado os endponts de acordo com o solicitado cumprindo os 


## Tecnologias Utilizadas

- **Java 11**
- **Kotlin**
- **Spring Boot**
- **JUnit** para testes unitários
- **Mockito** para mocking nos testes
- **Spring MVC Test** usando MockMvc para testes de controladores

## Testes

Os testes são realizados usando 
JUnit e Mockito. 


].
