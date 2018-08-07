package com.example.front.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Data
@AllArgsConstructor
public class RemoteData {
    private String id;
    private String body;
    private String serviceId;
}
