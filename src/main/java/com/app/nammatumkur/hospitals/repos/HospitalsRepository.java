package com.app.nammatumkur.hospitals.repos;

import com.app.nammatumkur.hospitals.model.Hospitals;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HospitalsRepository extends MongoRepository<Hospitals, String> {
    Hospitals findByName(String name);
    boolean existsByName(String name);
}
