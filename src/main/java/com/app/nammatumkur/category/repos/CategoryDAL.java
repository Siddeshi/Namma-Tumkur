package com.app.nammatumkur.category.repos;

import com.app.nammatumkur.category.model.Category;

import java.util.List;

public interface CategoryDAL {

    List<Category> getAllCategory() throws Exception;

    Category getCategoryById(String catId) throws Exception;

    void addNewCategory(Category category) throws Exception;

    Category deleteCategoryById(String catId) throws Exception;
}
