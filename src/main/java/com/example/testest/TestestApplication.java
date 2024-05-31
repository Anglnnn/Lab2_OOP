package com.example.testest;

import com.example.testest.configuration.KeycloakProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class }, scanBasePackages = {"com.example" })
@EnableConfigurationProperties(KeycloakProperties.class)

public class TestestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestestApplication.class, args);
    }

}
