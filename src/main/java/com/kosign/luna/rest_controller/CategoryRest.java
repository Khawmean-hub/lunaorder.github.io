package com.kosign.luna.rest_controller;

import java.util.List;

import com.kosign.luna.model.BaseApiResponse;
import com.kosign.luna.model.category.CategoryDao;
import com.kosign.luna.model.category.CategoryList;
import com.kosign.luna.service.category.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/category")
@Api(tags = "Category", value = "category", description = "")
public class CategoryRest {
    
    private CategoryService categoryService;
    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public BaseApiResponse getAllCategory(){
        BaseApiResponse res = new BaseApiResponse();
        res.setData(categoryService.findAllCategory());
        res.setCode("0000");
        res.setMessage("Fetch data successfully");
        return  res;
    }

    @PostMapping("/add")
    public BaseApiResponse save(@RequestBody CategoryDao categoryDao){
        BaseApiResponse resp = new BaseApiResponse();
        CategoryDao dao = categoryService.save(categoryDao);
        if(dao != null){
            resp.setCode("0000");
            resp.setMessage("Add successfully");
            resp.setData(dao);
            
        }else {
            resp.setCode("0001");
            resp.setMessage("Id already exist");
        }
        return resp;
    }

    @PutMapping("/update")
    public BaseApiResponse update(@Validated @RequestBody CategoryDao categoryDao){
        BaseApiResponse resp = new BaseApiResponse();
        CategoryDao dao = categoryService.update(categoryDao);
        if(dao != null){
            resp.setCode("0000");
            resp.setMessage("Updated successfully");
            resp.setData(dao);
        }else {
            resp.setCode("9999");
            resp.setMessage("Not found");
        }
        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public BaseApiResponse delete(@PathVariable int id){
        BaseApiResponse resp = new BaseApiResponse();
        CategoryDao dao = categoryService.delete(id);
        if(dao!=null){
            resp.setCode("0000");
            resp.setMessage("Delete successfully");
            resp.setData(dao);
        }else {
            resp.setCode("9999");
            resp.setMessage("Not found");
        }
        return resp;
    }
}
