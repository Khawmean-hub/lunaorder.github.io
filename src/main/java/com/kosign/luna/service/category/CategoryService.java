package com.kosign.luna.service.category;

import java.util.List;

import com.kosign.luna.model.category.CategoryDao;
import com.kosign.luna.model.category.CategoryList;



public interface CategoryService {
    List<CategoryList> findAllCategory();
    CategoryDao save(CategoryDao categoryDao);
    CategoryDao update(CategoryDao categoryDao);
    CategoryDao delete(int id);
}
