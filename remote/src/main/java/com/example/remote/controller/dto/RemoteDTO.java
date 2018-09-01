package com.example.remote.controller.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RemoteDTO {
    private String body;
    private String serviceId;

    public RemoteDTO() {
    }

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

    public void setBody(String body) {
        this.body = body;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
}
