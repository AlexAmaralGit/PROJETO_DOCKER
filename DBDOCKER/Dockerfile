FROM mysql:latest
ADD banca.sql /docker-entrypoint-initdb.d
ENV MYSQL_ROOT_PASSWORD root
ENV MYSQL_ROOT_USER root


##Gerar imagem
#docker run -d --rm --name mysql-container mysql:latest

##Gerar container com sqcript
#docker exec -i mysql-container mysql -uroot -pteste <banca.sql
#docker exec -i proj-db-1 mysql -uroot -proot <banca.sql 

#COMPOSER
#docker-compose up -d

##Acesso ternimal com bash comando  
#docker exec -it mysql-container /bin/bash

##Acesso mysql
#mysql -uroot -proot

##Usar o banco
#use <Banco>

##Comando mySQL
#show databases;
#show tables;   


##localhost:9000 PORTA DO DOCKER !!!
#quarkus.datasource.db-kind=mysql 
#quarkus.datasource.username=root
#quarkus.datasource.password=teste
#quarkus.datasource.jdbc.url=jdbc:mysql://localhost:9000/estoque
#quarkus.datasource.jdbc.max-size=16
#quarkus.hibernate-orm.log.sql=true


#### mysql -uroot -p1ESPACAO
#create user 'dbdev'@'localhost' identified by 'root';
#grant all privileges on * . * to 'dbdev'@'localhost';
#flush privileges;

  