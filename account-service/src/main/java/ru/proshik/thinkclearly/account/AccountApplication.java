package ru.proshik.thinkclearly.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Created by proshik on 04.10.2016.
 * <p>
 * For dev profile:
 * <p>
 * -Dspring.profiles.active=dev
 */
@EnableWebSecurity
@EnableFeignClients
@EnableEurekaClient
@EnableResourceServer
@EnableCircuitBreaker
@SpringBootApplication
@EnableAuthorizationServer
@EnableConfigurationProperties
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class);
    }
}
