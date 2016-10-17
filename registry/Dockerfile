FROM java:8-jre
MAINTAINER proshik <proxoraleksanrovich@gmail.com>

ADD ./target/registry.jar /app/

CMD ["java", "-Xmx128m", "-jar", "/app/registry.jar"]

EXPOSE 8761