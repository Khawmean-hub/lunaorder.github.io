package com.kosign.luna.repository;

import java.util.List;

import com.kosign.luna.model.category.CategoryDao;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<CategoryDao, Integer> {
    List<CategoryDao> findAllByParentIdOrderById(int id);
}
