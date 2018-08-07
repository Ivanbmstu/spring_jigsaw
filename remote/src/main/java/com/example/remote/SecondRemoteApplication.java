package com.example.remote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecondRemoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondRemoteApplication.class, "--server.port=8091");
    }
}
