package com.example.front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableMongoRepositories(basePackages = "com.example.front.repository")
public class FrontApplication {

    public static void main(String[] args) throws IOException {
        String lines = new BufferedReader(new InputStreamReader(FrontApplication.class.getClassLoader().getResourceAsStream("application.yml"))).readLine();
        System.out.println(lines);
        SpringApplication.run(FrontApplication.class, args);
    }
}
