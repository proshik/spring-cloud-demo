FROM java:8-jre
MAINTAINER proshik <proxoraleksanrovich@gmail.com>

ADD ./target/auth-service.jar /app/
CMD ["java", "-Xmx128m", "-jar", "/app/auth-service.jar"]

EXPOSE 9020