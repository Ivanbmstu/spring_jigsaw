package com.example.front.service;

import com.example.front.controller.RemoteClient;
import com.example.front.controller.RemoteJaxbClient;
import com.example.front.controller.dto.RemoteDataDTO;
import com.example.front.entity.BusinessData;
import com.example.front.repository.BusinessDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.example.front.util.JaxbUmarshall.unmarshall;


@Service
@Slf4j
@RequiredArgsConstructor
public class WorkService {
    private final RemoteClient remoteClient;
    private final RemoteJaxbClient remoteJaxbClient;
    private final BusinessDataRepository businessDataRepository;

    public String doWork(Integer id) {
        log.info("calling work with id " + id);
        RemoteDataDTO remoteDataDTO = remoteClient.callRemote(id);
        RemoteDataDTO remoteJaxbDataDTO = unmarshall(remoteJaxbClient.callRemote(id));
        BusinessData data = new BusinessData(UUID.randomUUID().toString(),
                remoteDataDTO.getBody(), remoteDataDTO.getServiceId());
        businessDataRepository.save(data);
        BusinessData data1 = new BusinessData(UUID.randomUUID().toString(),
                remoteJaxbDataDTO.getBody(), remoteJaxbDataDTO.getServiceId());
        businessDataRepository.save(data1);
        log.info("saved new entities");
        return remoteDataDTO.getBody() + " " + remoteJaxbDataDTO.getBody();
    }

}
