package ru.proshik.spring_cloud_demo.api_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by proshik on 04.10.2016.
 */
//@EnableOAuth2Client
@EnableFeignClients
//@EnableResourceServer
//@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigurationProperties
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
