FROM eclipse-temurin:17.0.6_10-jre

LABEL org.opencontainers.image.title="simple-rpg-gateway"
LABEL org.opencontainers.image.authors="Michał (psysiu) Wójcik"
LABEL org.opencontainers.image.source="https://git.pg.edu.pl/platformy-technologiczne/simple-rpg"
LABEL org.opencontainers.image.url="https://git.pg.edu.pl/internet-services-architectures"
LABEL org.opencontainers.image.vendor="Gdańsk University of Technology"
LABEL org.opencontainers.image.version="1.0.0-SNAPSHOT"
LABEL org.opencontainers.image.description="Simple RPG game, gateway module."
LABEL org.opencontainers.image.licenses="MIT"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="1.0.0-SNAPSHOT"

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:simple-rpg-gateway
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

ENV RPG_GATEWAY_HOST=localhost:8080
ENV RPG_CHARACTER_URL=http://localhost:8081
ENV RPG_PROFESSION_URL=http://localhost:8082
ENV RPG_USER_URL=http://localhost:8083

EXPOSE 8080

COPY target/simple-rpg-gateway-${VERSION}.jar /opt/simple-rpg-gateway/simple-rpg-gateway.jar

CMD ["java", "-jar", "/opt/simple-rpg-gateway/simple-rpg-gateway.jar"]
