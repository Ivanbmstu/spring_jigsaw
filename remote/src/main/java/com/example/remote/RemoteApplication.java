package com.example.remote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class RemoteApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(RemoteApplication.class, "--server.port=8092", "--trace=true");
    }
}
