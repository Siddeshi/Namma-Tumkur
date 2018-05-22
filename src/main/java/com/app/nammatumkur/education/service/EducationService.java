package com.app.nammatumkur.education.service;

import com.app.nammatumkur.category.model.Category;
import com.app.nammatumkur.education.model.Education;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EducationService {

    ResponseEntity<Object> addNewEducationType(String educationStr, String logoStr, MultipartFile file) throws Exception;
    ResponseEntity<List<Education>> getEducationTypes() throws Exception;
    ResponseEntity<Object> deleteEducationType(String id) throws Exception;
    ResponseEntity<Education> getEducation(String id) throws Exception;
}
