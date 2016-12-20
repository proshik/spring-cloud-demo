package ru.proshik.thinkclearly.topic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by proshik on 04.10.2016.
 * <p>
 * For dev profile:
 * <p>
 * -Dspring.profiles.active=dev
 */
@EnableFeignClients
@EnableEurekaClient
@EnableOAuth2Client
@EnableResourceServer
@EnableCircuitBreaker
@SpringBootApplication
@EnableTransactionManagement
@EnableConfigurationProperties
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class TopicApplication {

    public static void main(String[] args) {
        SpringApplication.run(TopicApplication.class);
    }
}
