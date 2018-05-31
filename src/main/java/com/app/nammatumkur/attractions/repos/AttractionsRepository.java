package com.app.nammatumkur.attractions.repos;

import com.app.nammatumkur.attractions.model.Attractions;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AttractionsRepository extends MongoRepository<Attractions, String> {
    Attractions findByName(String name);
    boolean existsByName(String name);
}
