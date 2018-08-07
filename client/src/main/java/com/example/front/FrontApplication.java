package com.example.front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class FrontApplication {
    
    public static void main(String[] args) throws IOException {
        String lines = new BufferedReader(new InputStreamReader(FrontApplication.class.getClassLoader().getResourceAsStream("application.yml"))).readLine();
        System.out.println(lines);
        SpringApplication.run(FrontApplication.class, args);
    }
}
