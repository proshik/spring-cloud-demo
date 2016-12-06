package ru.proshik.thinkclearly.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by proshik on 05.10.16.
 * <p>
 * The HTTP service has resources in the form:
 * <p>
 * /{application}/{profile}[/{label}]
 * /{application}-{profile}.yml
 * /{label}/{application}-{profile}.yml
 * /{application}-{profile}.properties
 * /{label}/{application}-{profile}.properties
 * <p>
 * where the "application" is injected as the spring.config.name in the SpringApplication(i.e. what is
 * normally "application" in a regular Spring Boot app), "profile" is an active profile(or comma-separated
 * list of properties), and "label" is an optional git label (defaults to "master".)
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class);
    }

}
