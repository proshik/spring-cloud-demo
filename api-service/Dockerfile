FROM java:8-jre
MAINTAINER proshik <proxoraleksanrovich@gmail.com>

COPY ./target/api-service.jar /app/
CMD ["java", "-Xmx128m", "-jar", "/app/api-service.jar"]

EXPOSE 9010