package com.app.nammatumkur.category.service;

import com.app.nammatumkur.category.model.Category;
import com.app.nammatumkur.category.repos.CategoryDAL;
import com.app.nammatumkur.category.repos.CategoryRepository;
import com.app.nammatumkur.logos.model.Logo;
import com.app.nammatumkur.logos.repos.LogosDAL;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(LogosDAL logosDAL, CategoryDAL categoryDAL, CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public ResponseEntity<Object> addNewCategory(String categoryStr, MultipartFile file) throws Exception {

        try {

            logger.debug("Adding new category");

            ObjectMapper objectMapper = new ObjectMapper();

            Category categoryObj = objectMapper.readValue(new JSONObject(categoryStr).getJSONObject("category").toString(), Category.class);

            Logo logo = new Logo(file.getBytes(), file.getOriginalFilename(), file.getContentType(), new Date());

            Category category;
            if (!categoryRepository.existsByType(categoryObj.getType())) { // check category is exists
                category = new Category();

                category.setType(categoryObj.getType());
                category.setLogos(logo);
                categoryRepository.save(category);
                return new ResponseEntity<>("Added new category successfully",HttpStatus.CREATED);
            } else { //if exists update category
                category = categoryRepository.findByType(categoryObj.getType());
                category.setLogos(logo);
                categoryRepository.save(category);
                return new ResponseEntity<>("Updated category successfully",HttpStatus.CREATED);
            }

        } catch (Exception ex) {

            logger.error("Exception while adding new category " + ex.getCause().getMessage());
            ex.printStackTrace();
            throw ex;

        } finally {
        }
    }

    @Override
    @Transactional
    public ResponseEntity<List<Category>> categoryList() throws Exception {

        try {

            logger.debug("list of all categories");

            return new ResponseEntity<List<Category>>(categoryRepository.findAll(), HttpStatus.OK);

        } catch (Exception ex) {

            logger.error("Exception while fetching listing the categories: " + ex.getCause().getMessage());
            ex.printStackTrace();
            throw ex;

        } finally {

        }
    }

    @Override
    @Transactional
    public ResponseEntity<Object> deleteCategoryById(String id) throws Exception {


        try {

            logger.debug("Deleting category with ID: " + id);
            if (!categoryRepository.exists(id)) {
                return new ResponseEntity<Object>("Category not exist", HttpStatus.OK);
            }
            categoryRepository.delete(id);
            return new ResponseEntity<Object>("Deleted category successfully.", HttpStatus.OK);

        } catch (Exception ex) {

            logger.error("Exception while deleting the category: " + ex.getCause().getMessage());
            ex.printStackTrace();
            throw ex;

        } finally {

        }
    }

    @Override
    @Transactional
    public ResponseEntity<Category> getCategoryById(String id) throws Exception {

        try {

            logger.debug("listing category with ID: " + id);

            return new ResponseEntity<Category>(categoryRepository.findOne(id), HttpStatus.OK);

        } catch (Exception ex) {

            logger.error("Exception while fetching category by id: " + ex.getCause().getMessage());
            ex.printStackTrace();
            throw ex;

        } finally {

        }
    }

    @Override
    @Transactional
    public ResponseEntity<Object> deleteAllCategories() throws Exception {

        try {
            logger.debug("Deleting all the categories");
            categoryRepository.deleteAll();
            return new ResponseEntity<>("Deleted all the categories", HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            logger.error("Exception while deleting all the categories");
            ex.printStackTrace();
            throw ex;
        } finally {

        }
    }
}
