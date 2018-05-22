package com.app.nammatumkur.education.controller;

import com.app.nammatumkur.education.model.Education;
import com.app.nammatumkur.education.service.EducationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/*
 * 20/05/2018
 * Siddesh B S
* */

public class EducationController {


    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final EducationService educationService;

    public EducationController(EducationService educationService) {

        this.educationService = educationService;
    }

    @RequestMapping(value = "addedu", method = RequestMethod.POST)
    public ResponseEntity<Object> addNewEducationType(@RequestParam("edu") String eduStr, @RequestParam("logo") String logo, @RequestParam("file") MultipartFile file) throws Exception {
        return educationService.addNewEducationType(eduStr, logo, file);
    }

    @RequestMapping(value = "listedu", method = RequestMethod.GET)
    public ResponseEntity<List<Education>> getEducationTypes() throws Exception {
        return educationService.getEducationTypes();
    }

    @RequestMapping(value = "deleteedu", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCategory(@RequestParam("id") String id) throws Exception {
        return educationService.deleteEducationType(id);
    }

    @RequestMapping(value = "getedu", method = RequestMethod.GET)
    public ResponseEntity<Education> getCategoryById(@RequestParam("id") String id) throws Exception {
        return educationService.getEducation(id);
    }
}
