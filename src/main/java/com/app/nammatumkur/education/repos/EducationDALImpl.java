package com.app.nammatumkur.education.repos;

import com.app.nammatumkur.education.model.Education;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

public class EducationDALImpl implements EducationDAL {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Education> getEducationTypes() throws Exception {
        return null;
    }

    @Override
    public Education getEducation(String id) throws Exception {
        return null;
    }

    @Override
    public void addNewEducationType(Education education) throws Exception {

    }

    @Override
    public Education deleteEducationType(String id) throws Exception {
        return null;
    }
}
