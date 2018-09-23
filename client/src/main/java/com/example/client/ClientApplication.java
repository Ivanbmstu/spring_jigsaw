package com.example.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) throws IOException {
        System.out.println("Running module: " + ClientApplication.class.getModule().getName());
        SpringApplication.run(ClientApplication.class, args);
    }
}
