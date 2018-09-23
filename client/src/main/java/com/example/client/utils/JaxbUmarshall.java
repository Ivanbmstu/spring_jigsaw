package com.example.client.utils;

import com.example.client.controller.dto.RemoteDataDTO;

import javax.xml.bind.JAXB;
import java.io.StringReader;

public class JaxbUmarshall {


    public static RemoteDataDTO unmarshall(String body) {
        return JAXB.unmarshal(new StringReader(body), RemoteDataDTO.class);
    }
}
