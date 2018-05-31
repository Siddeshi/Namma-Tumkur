package com.app.nammatumkur.temples.repos;

import com.app.nammatumkur.temples.model.Temples;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TemplesRepository extends MongoRepository<Temples, String> {
    Temples findByName(String name);
    boolean existsByName(String name);
}
