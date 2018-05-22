package com.app.nammatumkur.category.controller;

import com.app.nammatumkur.category.model.Category;
import com.app.nammatumkur.category.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by siddesh on 12/05/18.
 * This class provides REST services to handle categories.
 */

@RestController
@RequestMapping(value = "/")
public class CategoryController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {

        this.categoryService = categoryService;
    }

    /**
     * add category.
     * Created by siddesh on 12/05/18
     */

    @RequestMapping(value = "addcategory", method = RequestMethod.POST)
    public ResponseEntity<Object> addNewCategory(@RequestParam("category") String category, @RequestParam("logo") String logo, @RequestParam("file") MultipartFile file) throws Exception {
        return categoryService.addNewCategory(category, logo, file);
    }

    /**
     * list categories.
     * Created by siddesh on 12/05/18
     */

    @RequestMapping(value = "listcategory", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> categoryList() throws Exception {

        return categoryService.categoryList();
    }

    /**
     * delete category by id.
     * Created by siddesh on 12/05/18
     */

    @RequestMapping(value = "deletecategory", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCategory(@RequestParam String catId) throws Exception {

        return categoryService.deleteCategoryById(catId);
    }

    /**
     * get category by id.
     * Created by siddesh on 12/05/18
     */

    @RequestMapping(value = "getcategorybyid", method = RequestMethod.GET)
    public ResponseEntity<Category> getCategoryById(@RequestParam String catId) throws Exception {

        return categoryService.getCategoryById(catId);
    }
}
