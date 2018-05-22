package com.app.nammatumkur.category.repos;

import com.app.nammatumkur.category.model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CategoryDALImpl implements CategoryDAL {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    @Transactional
    public List<Category> getAllCategory() throws Exception {

        try {

            logger.debug("get all the categories");
            return mongoTemplate.findAll(Category.class);

        } catch (Exception ex) {

            logger.error("Exception while fetching categories: " + ex.getCause().getMessage());
            ex.printStackTrace();
            throw ex;

        } finally {

        }
    }

    @Override
    @Transactional
    public Category getCategoryById(String catId) {

        try {

            logger.debug("fetching a category by id");

            Query query = new Query();
            query.addCriteria(Criteria.where("catId").is(catId));
            Category category = mongoTemplate.findOne(query, Category.class);
            return category != null ? category : null;

        } catch (Exception ex) {

            logger.error("Exception while fetching a single category: " + ex.getCause().getMessage());
            ex.printStackTrace();
            throw ex;
        } finally {

        }
    }

    @Override
    @Transactional
    public void addNewCategory(Category category) {

        try {

            logger.debug("adding a new category");

            mongoTemplate.save(category);

        } catch (Exception ex) {

            logger.error("Exception while saving category: " + ex.getCause().getMessage());
            ex.printStackTrace();
            throw ex;

        } finally {

        }
    }

    @Override
    @Transactional
    public Category deleteCategoryById(String catId) {

        try {

            logger.debug("Deleting a category by id");

            Query query = new Query();
            query.addCriteria(Criteria.where("catId").is(catId));
            Category category = mongoTemplate.findAndRemove(query, Category.class);
            return category != null ? category : null;

        } catch (Exception ex) {

            logger.error("Exception while deleting a category: " + ex.getCause().getMessage());
            ex.printStackTrace();
            throw ex;

        } finally {

        }
    }
}
