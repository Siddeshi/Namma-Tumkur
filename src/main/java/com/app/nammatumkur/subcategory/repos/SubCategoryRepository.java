package com.app.nammatumkur.subcategory.repos;

import com.app.nammatumkur.subcategory.model.SubCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends MongoRepository<SubCategory, String> {
    List<SubCategory> findByType(String name);
}
