package com.example.front.repository;

import com.example.front.entity.BusinessData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BusinessDataRepository extends MongoRepository<BusinessData, String> {
}
