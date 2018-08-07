package com.example.remote.controller.dto;

public class RemoteDTO {
    private String body;
    private String serviceId;

    public RemoteDTO(String body, String serviceId) {
        this.body = body;
        this.serviceId = serviceId;
    }

    public String getBody() {
        return body;
    }

    public String getServiceId() {
        return serviceId;
    }
}
