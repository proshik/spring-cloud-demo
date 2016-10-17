FROM java:8-jre
MAINTAINER proshik <proxoraleksanrovich@gmail.com>

COPY ./target/monitoring.jar /app/
CMD ["java", "-Xmx128m", "-jar", "/app/monitoring.jar"]

EXPOSE 8787 8989