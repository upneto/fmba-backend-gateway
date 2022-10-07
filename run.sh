## Cria Jar do projeto ##
mvn clean install package

## Executa criação da imagem Docker ##
docker-compose down
docker rm fmba-backend-gateway --force
docker-compose up
