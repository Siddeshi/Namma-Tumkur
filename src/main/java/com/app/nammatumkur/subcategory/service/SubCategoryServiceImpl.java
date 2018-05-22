package com.app.nammatumkur.subcategory.service;

import com.app.nammatumkur.logos.model.Logo;
import com.app.nammatumkur.subcategory.model.SubCategory;
import com.app.nammatumkur.subcategory.repos.SubCategoryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.EmptyStackException;
import java.util.List;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    private final SubCategoryRepository subCategoryRepository;

    public SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository= subCategoryRepository;

    }

    @Override
    public List<SubCategory> findByType(String type) throws Exception {
        return subCategoryRepository.findByType(type);
    }

    @Override
    public Object save(String subcatStr, String logoStr, MultipartFile file) throws Exception {

        try {

            ObjectMapper objectMapper = new ObjectMapper();
            SubCategory subCategory = objectMapper.readValue(subcatStr, SubCategory.class);
            Logo logoObj = objectMapper.readValue(logoStr, Logo.class);

            Logo logo = new Logo(file.getBytes(), logoObj.getDescription(), logoObj.getFilename(), file.getContentType(), new Date());

            subCategory.setLogo(logo);
            return subCategoryRepository.save(subCategory).getName() + " saved successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {

        }
    }

}
