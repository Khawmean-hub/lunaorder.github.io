package com.kosign.luna.service.category;

import java.util.ArrayList;
import java.util.List;

import com.kosign.luna.model.category.CategoryDao;
import com.kosign.luna.model.category.CategoryList;
import com.kosign.luna.repository.CategoryRepo;
import com.kosign.luna.util.ApiMapperUtile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImp implements CategoryService{

    private CategoryRepo categoryRepo;
    private ApiMapperUtile apiMapperUtile;

    @Autowired
    public void setCategoryRepo(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Autowired
    public void setApiMapperUtile(ApiMapperUtile apiMapperUtile) {
        this.apiMapperUtile = apiMapperUtile;
    }

    @Override
    public List<CategoryList> findAllCategory() {
        List<CategoryDao> cat = categoryRepo.findAllByParentIdOrderById(0);
        List<CategoryList> listRes = new ArrayList<>();
        for (CategoryDao categoryDao : cat) {
             CategoryList cList = apiMapperUtile.mapper().map(categoryDao, CategoryList.class);
             cList.setSubCategory(categoryRepo.findAllByParentIdOrderById(cList.getId()));
             listRes.add(cList);

        }
        return listRes;
    }


    @Override
    public CategoryDao delete(int id) {
        CategoryDao dao = categoryRepo.findById(id).orElse(null);
        if(dao!=null) {
            categoryRepo.deleteById(id);
            return dao;
        }else {
            return null;
        }
    }

    @Override
    public CategoryDao save(CategoryDao categoryDao) {
        CategoryDao dao = categoryRepo.findById(categoryDao.getId()).orElse(null);
        if(dao==null) {
            categoryRepo.save(categoryDao);
            return categoryDao;
        }else {
            return null;
        }
    }

    @Override
    public CategoryDao update(CategoryDao categoryDao) {
        CategoryDao dao = categoryRepo.findById(categoryDao.getId()).orElse(null);
        if(dao!=null) {
            categoryRepo.save(categoryDao);
            return categoryDao;
        }else {
            return null;
        }
    }
    
}
