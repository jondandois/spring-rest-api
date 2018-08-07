# SpringData DynamoDB Sample REST API

## Requirements
- Have DynamoDB running locally: https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.html

## Commands
- `mvn test` to run Junit tests
- `mvn clean spring-boot:run` to launch the app at `localhost:8000`

## Endpoints
`/save` - will populate the DynamoDB with example entities
`/delete` - will clear example entities
`/findall` - retrieve all example entities as JSON
`/findbyid?id=:id` - get a single record by id
`/findbyfirstname?firstname=:firstname` - get a collection of all entities by name

## Reference
- https://grokonez.com/spring-framework/spring-data/how-to-use-spring-data-dynamodb-example-spring-boot
