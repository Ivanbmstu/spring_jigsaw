package com.example.front.repository;

import com.example.front.entity.RemoteData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RemoteDataRepository extends MongoRepository<RemoteData, String> {
}
