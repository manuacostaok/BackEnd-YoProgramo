FROM amazoncorretto:11-alpine-jdk
MAINTAINER ManuAcosta
COPY target/yoProgramo-0.0.1-SNAPSHOT.jar portfolioManuAcosta-app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/portfolioManuAcosta-app.jar"]
