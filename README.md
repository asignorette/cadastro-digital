## cadastro-digital


### Tecnologias utilizadas:
* Spring Boot (json/restful) 
* Apache Camel
* Maven
* Swagger
* JUnit

### Endpoints:
- Swagger (GET): http://localhost:8080/swagger-ui
- Rota bancos (GET): /api/bancos

## Responses:

-Rota bancos
  [{"id":-1,"nome":"XXX-Desconhecido","numero":"XXX"},{"id":1,"nome":"000-Banco Bankpar S.A.","numero":"000"},{"id":2,"nome":"001-Banco do Brasil S.A.","numero":"001"},{"id":3,"nome":"003-Banco da Amazônia S.A.","numero":"003"}]


## Para rodar
mvn spring-boot:run
