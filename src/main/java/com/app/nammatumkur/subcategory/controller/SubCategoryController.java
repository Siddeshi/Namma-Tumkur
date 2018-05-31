package com.app.nammatumkur.subcategory.controller;

import com.app.nammatumkur.education.model.Education;
import com.app.nammatumkur.subcategory.model.SubCategory;
import com.app.nammatumkur.subcategory.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by siddesh on 20/05/18.
 * This class provides REST services to handle subcategories.
 */

@Controller
@RequestMapping(value = "/")
public class SubCategoryController {

    @Autowired
    SubCategoryService subCategoryService;

    public SubCategoryController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    /**
     * list subcategories.
     * Created by siddesh on 20/05/18
     */

    @RequestMapping(value = "{type}", method = RequestMethod.GET)
    public ResponseEntity<List<SubCategory>> subCategoryList(@PathVariable("type") String type) throws Exception {
        return new ResponseEntity<List<SubCategory>>(subCategoryService.findByType(type), HttpStatus.OK);
    }

    /**
     * add a sub category.
     * Created by siddesh on 20/05/18
     */
    @RequestMapping(value = "addsubcat", method = RequestMethod.POST)
    public ResponseEntity<Object> addSubCat(@RequestParam("subcat") String subcatStr, @RequestParam("file") MultipartFile file) throws Exception {
        return new ResponseEntity<>(subCategoryService.save(subcatStr, file), HttpStatus.OK);
    }

    /**
     * add a sub category.
     * Created by siddesh on 20/05/18
     */
    @RequestMapping(value = "removesubcat", method = RequestMethod.POST)
    public ResponseEntity<Object> removeSubCat(@RequestParam String id) throws Exception {
        return new ResponseEntity<>(subCategoryService.removeSubCat(id), HttpStatus.OK);
    }

    /**
     * add a list category.
     * Created by siddesh on 27/05/18
     */
    @RequestMapping(value = "{type}/{name}", method = RequestMethod.GET)
    public ResponseEntity<Object> findByTypeAndName(@PathVariable("type") String type, @PathVariable("name") String name) throws Exception {
        return new ResponseEntity<>(subCategoryService.findByTypeAndName(type, name), HttpStatus.OK);
    }

    @RequestMapping(value = "deleteall", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAll() throws Exception {
        subCategoryService.deleteAll();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
