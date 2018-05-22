package com.app.nammatumkur.education.service;

import com.app.nammatumkur.education.model.Education;
import com.app.nammatumkur.education.repos.EducationDAL;
import com.app.nammatumkur.education.repos.EducationDALImpl;
import com.app.nammatumkur.logos.repos.LogosDAL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class EducationServiceImpl implements EducationService {


    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final EducationDAL educationDAL;
    private final LogosDAL logosDAL;

    public EducationServiceImpl(EducationDAL educationDAL, LogosDAL logosDAL) {
        this.educationDAL = educationDAL;
        this.logosDAL = logosDAL;
    }

    @Override
    public ResponseEntity<Object> addNewEducationType(String educationStr, String logoStr, MultipartFile file) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<Education>> getEducationTypes() throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<Object> deleteEducationType(String id) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<Education> getEducation(String id) throws Exception {
        return null;
    }
}
