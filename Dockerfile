FROM amazoncorretto:17-alpine-jdk
MAINTAINER ManuAcosta
COPY target/yoProgramo-0.0.1-SNAPSHOT.jar portfolioManuAcosta-app.jar
ENTRYPOINT ["java","-jar","/portfolioManuAcosta-app.jar"]
