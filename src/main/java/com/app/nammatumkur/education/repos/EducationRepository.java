package com.app.nammatumkur.education.repos;

import com.app.nammatumkur.education.model.Education;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EducationRepository extends MongoRepository<Education, String> {
}
