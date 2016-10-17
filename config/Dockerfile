FROM java:8-jre
MAINTAINER proshik <proxoraleksanrovich@gmail.com>

COPY ./target/config.jar /app/
CMD ["java", "-Xmx128m", "-jar", "/app/config.jar"]

EXPOSE 8888