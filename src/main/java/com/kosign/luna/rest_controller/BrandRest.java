package com.kosign.luna.rest_controller;

import java.util.ArrayList;
import java.util.List;

import com.kosign.luna.model.BaseApiResponse;
import com.kosign.luna.model.EmptyJsonBody;
import com.kosign.luna.model.PageReq;
import com.kosign.luna.model.brand.Brand;
import com.kosign.luna.repository.BrandRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(tags = "Brand", value = "brand", description = "")
@RequestMapping("/brand")
public class BrandRest {
    private BrandRepo brandRepo;
    @Autowired
    public void setBrandRepo(BrandRepo brandRepo) {
        this.brandRepo = brandRepo;
    }

    @GetMapping("/all")
    public BaseApiResponse listAll(){
        
        BaseApiResponse resp = new BaseApiResponse();
        List<Brand> list = new ArrayList<>();
        brandRepo.findAll().forEach(list::add);
        resp.setCode("0000");
        resp.setMessage("Fetch data successfully");
        resp.setData(list);
        return resp;
    }

    @PostMapping()
    public BaseApiResponse getAll(@RequestParam(defaultValue = "") String name, PageReq pageRequest){
        Pageable pageable = PageRequest.of(pageRequest.getPage(), pageRequest.getOffset(), Sort.by("name"));
        BaseApiResponse resp = new BaseApiResponse();
        resp.setCode("0000");
        resp.setMessage("Fetch data successfully");
        resp.setData(brandRepo.findAllByNameContaining(name, pageable));
        return resp;
    }

    @PostMapping("/add")
    public BaseApiResponse save(@RequestBody Brand brand){
        BaseApiResponse resp = new BaseApiResponse();
        Brand brn = brandRepo.findById(brand.getId()).orElse(null);
        if(brn == null){
            resp.setCode("0000");
            resp.setMessage("Add successfully");
            resp.setData(brand);
            brandRepo.save(brand);
        }else {
            resp.setCode("0001");
            resp.setMessage("Id already exist");
        }
        return resp;
    }

    @PutMapping("/update")
    public BaseApiResponse update(@Validated @RequestBody Brand brand){
        BaseApiResponse resp = new BaseApiResponse();
        Brand brn = brandRepo.findById(brand.getId()).orElse(null);
        if(brn != null){
            resp.setCode("0000");
            resp.setMessage("Updated successfully");
            resp.setData(brand);
            brandRepo.save(brand);
        }else {
            resp.setCode("9999");
            resp.setMessage("Not found");
        }
        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public BaseApiResponse delete(@PathVariable int id){
        BaseApiResponse resp = new BaseApiResponse();
        if(brandRepo.findById(id) != null){
            resp.setCode("0000");
            resp.setMessage("Delete successfully");
            brandRepo.deleteById(id);
        }else {
            resp.setCode("9999");
            resp.setMessage("Not found");
        }
        return resp;
    }
}
