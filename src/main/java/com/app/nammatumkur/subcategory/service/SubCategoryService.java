package com.app.nammatumkur.subcategory.service;

import com.app.nammatumkur.education.model.Education;
import com.app.nammatumkur.subcategory.model.SubCategory;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SubCategoryService {

    List<SubCategory> findByType(String type) throws Exception;
    Object save(String subcatStr, MultipartFile file) throws Exception;
    Object removeSubCat(String id) throws Exception;
    Education findByTypeAndName(String type, String name) throws Exception;
}
