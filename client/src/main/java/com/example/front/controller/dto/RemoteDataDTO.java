package com.example.front.controller.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@XmlRootElement
public class RemoteDataDTO {
    private String body;
    private String serviceId;
}
