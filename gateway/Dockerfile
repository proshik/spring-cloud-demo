FROM java:8-jre
MAINTAINER proshik <proxoraleksanrovich@gmail.com>

COPY ./target/gateway.jar /app/
CMD ["java", "-Xmx128m", "-jar", "/app/gateway.jar"]

EXPOSE 4000