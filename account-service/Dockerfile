FROM java:8-jre
MAINTAINER proshik <proxoraleksanrovich@gmail.com>

ADD ./target/account-service.jar /app/
CMD ["java", "-Xmx128m", "-jar", "/app/account-service.jar"]

EXPOSE 9020