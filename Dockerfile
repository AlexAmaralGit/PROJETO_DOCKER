FROM registry.access.redhat.com/ubi8/openjdk-11:1.11
COPY --chown=185 target/quarkus-app/lib/ /deployments/lib/
COPY --chown=185 target/*.jar /deployments/
COPY --chown=185 target/quarkus-app/app/ /deployments/app/
COPY --chown=185 target/quarkus-app/quarkus/ /deployments/quarkus/
RUN ls /deployments/app/
ENTRYPOINT ["java", "-jar", "/deployments/quarkus-hello-world-maven-1.0.0-SNAPSHOT-runner.jar"]
#
#
#FROM maven:3.8.5-openjdk-11-slim
#WORKDIR /work/
#COPY . /app
#RUN mvn clean install
#RUN ls /app/target
#RUN chown 1001 /work \
#     && chmod "g+rwX" /work \
#     && chown 1001:root /work
#COPY --chown=1001:root target/quarkus-hello-world-maven-1.0.0-SNAPSHOT-runner.jar /work/application

#EXPOSE 8080 mvnw package -Dquarkus.package.type=uber-jar
#USER 1001

#ENTRYPOINT ["java", "-jar", "/app/target/quarkus-hello-world-maven-1.0.0-SNAPSHOT-runner.jar"]

#COMMNANDO PARA GERAR IMAGEM docker build --tag quarkus-dockfile . --NA PASTA DO DOCKERFILE

#FROM maven:3.8.5-openjdk-11-slim AS build
#WORKDIR /app
#EXPOSE 8080
#COPY . /app
#RUN mvn clean install
#RUN ls /app/target
#RUN chown -R /app
#USER root
#ENTRYPOINT ["java", "-jar", "/app/target/quarkus-hello-world-maven-1.0.0-SNAPSHOT-runner.jar"]


#FROM maven:3.8.5-openjdk-11-slim AS build
#WORKDIR /work/
#RUN chown 1001 /work \
#    && chmod "g+rwX" /work \
#    && chown 1001:root /work
#COPY --chown=1001:root target/*-runner /work/application      

#EXPOSE 8080
#USER 1001

#CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]