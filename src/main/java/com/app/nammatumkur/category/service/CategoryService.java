package com.app.nammatumkur.category.service;

import com.app.nammatumkur.category.model.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CategoryService {

    ResponseEntity<Object> addNewCategory(String categoryStr, String logoStr, MultipartFile file) throws Exception;
    ResponseEntity<List<Category>> categoryList() throws Exception;
    ResponseEntity<Object> deleteCategoryById(String id) throws Exception;
    ResponseEntity<Category> getCategoryById(String id) throws Exception;
}
