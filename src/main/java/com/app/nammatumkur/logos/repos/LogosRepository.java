package com.app.nammatumkur.logos.repos;

import com.app.nammatumkur.logos.model.Logo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogosRepository extends MongoRepository<Logo, String> {
}