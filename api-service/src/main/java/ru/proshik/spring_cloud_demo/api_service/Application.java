package ru.proshik.spring_cloud_demo.api_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Created by PKrylov on 04.10.2016.
 */
//@EnableOAuth2Client
@EnableFeignClients
@EnableResourceServer
@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigurationProperties
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
