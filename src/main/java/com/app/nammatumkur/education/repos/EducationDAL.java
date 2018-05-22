package com.app.nammatumkur.education.repos;

import com.app.nammatumkur.education.model.Education;

import java.util.List;

public interface EducationDAL {

    List<Education> getEducationTypes() throws Exception;

    Education getEducation(String id) throws Exception;

    void addNewEducationType(Education education) throws Exception;

    Education deleteEducationType(String id) throws Exception;
}
