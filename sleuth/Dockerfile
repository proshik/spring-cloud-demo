FROM java:8-jre
MAINTAINER proshik <proxoraleksanrovich@gmail.com>

COPY ./target/sleuth.jar /app/
CMD ["java", "-Xmx128m", "-jar", "/app/sleuth.jar"]

EXPOSE 9411