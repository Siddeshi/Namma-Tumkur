package com.app.nammatumkur.hotspots.repos;

import com.app.nammatumkur.hotspots.model.Hotspots;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HotspotsRepository extends MongoRepository<Hotspots, String> {
    Hotspots findByName(String name);
    boolean existsByName(String name);
}
