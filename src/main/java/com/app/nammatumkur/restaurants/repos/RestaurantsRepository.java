package com.app.nammatumkur.restaurants.repos;

import com.app.nammatumkur.restaurants.model.Restaurants;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestaurantsRepository extends MongoRepository<Restaurants, String> {
    Restaurants findByName(String name);
    boolean existsByName(String name);
}
