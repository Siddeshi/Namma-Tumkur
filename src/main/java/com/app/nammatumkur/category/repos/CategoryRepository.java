package com.app.nammatumkur.category.repos;

import com.app.nammatumkur.category.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
    @Override
    List<Category> findAll();
    boolean existsByType(String type);
    Category findByType(String type);
}
