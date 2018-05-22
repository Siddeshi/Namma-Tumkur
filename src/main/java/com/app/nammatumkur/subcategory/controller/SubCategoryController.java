package com.app.nammatumkur.subcategory.controller;

import com.app.nammatumkur.subcategory.model.SubCategory;
import com.app.nammatumkur.subcategory.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    public SubCategoryController() {
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
    public ResponseEntity<Object> addSubCat(@RequestParam("subcat") String subcatStr, @RequestParam("logo") String logoStr, @RequestParam("file") MultipartFile file) throws Exception {
        return new ResponseEntity<>(subCategoryService.save(subcatStr, logoStr, file), HttpStatus.OK);
    }
}
