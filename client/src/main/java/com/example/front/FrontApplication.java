package com.example.front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class FrontApplication {

    public static void main(String[] args) throws IOException {
        System.out.println("Running module: " + FrontApplication.class.getModule().getName());
        SpringApplication.run(FrontApplication.class, args);
    }
}
