package com.app.nammatumkur.subcategory.service;

import com.app.nammatumkur.subcategory.model.SubCategory;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SubCategoryService {

    List<SubCategory> findByType(String type) throws Exception;
    Object save(String subcatStr, String logoStr, MultipartFile file) throws Exception;
}
