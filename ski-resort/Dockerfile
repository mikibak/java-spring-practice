FROM eclipse-temurin:17.0.6_10-jre

LABEL org.opencontainers.image.title="ski-resort"
LABEL org.opencontainers.image.version="1"
LABEL org.opencontainers.image.description="Ski resort application, ski resort module."

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="1"

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:simple-rpg-profession
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

ENV RPG_CHARACTER_URL=http://localhost:8081

EXPOSE 8080

COPY target/ski-resort-${VERSION}.jar /opt/ski-resort/ski-resort.jar

CMD ["java", "-jar", "/opt/ski-resort/ski-resort.jar"]
