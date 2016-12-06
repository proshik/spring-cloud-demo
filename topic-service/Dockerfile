FROM java:8-jre
MAINTAINER proshik <proxoraleksanrovich@gmail.com>

COPY ./target/topic-service.jar /app/
CMD ["java", "-Xmx128m", "-jar", "/app/topic-service.jar"]

EXPOSE 9010