package ru.proshik.spring_cloud_demo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by proshik on 04.10.2016.
 * <p>
 * -Dspring.profiles.active=dev
 */
@EnableFeignClients
@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
@EnableConfigurationProperties
//@EnableOAuth2Client
//@EnableResourceServer
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class);
    }
}
