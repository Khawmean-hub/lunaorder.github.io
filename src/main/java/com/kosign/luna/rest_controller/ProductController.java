package com.kosign.luna.rest_controller;

import java.util.HashMap;
import java.util.List;

import com.kosign.luna.model.BaseApiResponse;
import com.kosign.luna.model.EmptyJsonBody;
import com.kosign.luna.model.PageReq;
import com.kosign.luna.model.brand.Brand;
import com.kosign.luna.model.category.CategoryDao;
import com.kosign.luna.model.product.Product;
import com.kosign.luna.model.product.ProductDetailDao;
import com.kosign.luna.model.product.ProductFilter;
import com.kosign.luna.model.product.ProductReq;
import com.kosign.luna.repository.ProductDetailRepo;
import com.kosign.luna.service.product.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/prudcut")
@Api(tags = "Product", value = "product", description = "product for")
public class ProductController {
    private ProductService productService;
    private ProductDetailRepo productDetailRepo;
    
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    @Autowired
    public void setProductDetailRepo(ProductDetailRepo productDetailRepo) {
        this.productDetailRepo = productDetailRepo;
    }

    @PostMapping("/")
    public BaseApiResponse findAll(ProductFilter filter, PageReq pageReq){
        BaseApiResponse result = new BaseApiResponse();
        Pageable pageable = PageRequest.of(pageReq.getPage(), pageReq.getOffset(), pageReq.getSortDirection(), pageReq.getSortBy());
            result.setCode("0000");
            result.setMessage("fetch data ok");
            result.setData(productService.findByNameContaining(filter, pageable));
        return result;
    }

    @PostMapping("/add")
    public BaseApiResponse save(@RequestBody ProductReq product){
        BaseApiResponse result = new BaseApiResponse();
        Product product2 = new Product();
        product2.setName(product.getName());
        product2.setDescription(product.getDescription());
        product2.setDiscount(product.getDiscount());
        product2.setPrice(product.getPrice());
        product2.setProfile(product.getProfile());
        product2.setStock(product.getStock());
        product2.setRegisterDate(product.getRegisterDate());
        product2.setBrand(new Brand(product.getBrandId(), "", ""));
        product2.setCategory(new CategoryDao(product.getCategoryId(), "", 0, ""));
        Product res  = productService.save(product2);
        if(res != null){
            result.setCode("0000");
            result.setMessage("save successfully");
            result.setData(res);
        }else {
            result.setCode("0001");
            result.setMessage("Product already exist");
        }

        return result;
    }

    @PutMapping("/update")
    public BaseApiResponse update(@RequestBody ProductReq product){
        BaseApiResponse result = new BaseApiResponse();
        Product product2 = new Product();
        product2.setId(product.getId());
        product2.setName(product.getName());
        product2.setDescription(product.getDescription());
        product2.setDiscount(product.getDiscount());
        product2.setPrice(product.getPrice());
        product2.setStock(product.getStock());
        product2.setProfile(product.getProfile());
        product2.setRegisterDate(product.getRegisterDate());
        product2.setBrand(new Brand(product.getBrandId(), "", ""));
        product2.setCategory(new CategoryDao(product.getCategoryId(), "", 0, ""));
        Product res  = productService.update(product2);
        if(res != null){
            result.setCode("0000");
            result.setMessage("update successfully");
            result.setData(res);
        }else {
            result.setCode("0001");
            result.setMessage("not found");
        }

        return result;
    }

    @DeleteMapping("/delete/{id}")
    public BaseApiResponse delete(@PathVariable int id){
        BaseApiResponse result = new BaseApiResponse();
        Product product = productService.findById(id);
        boolean res  = productService.delete(id);
        productDetailRepo.deleteById(id);
        if(res){
            result.setCode("0000");
            result.setMessage("delete successfully");
            result.setData(product);
        }else {
            result.setCode("0001");
            result.setMessage("not found");
        }
        return result;
    }

    @PostMapping("/find/{id}")
    public BaseApiResponse findById(@PathVariable int id){
        BaseApiResponse result = new BaseApiResponse();
        Product res = productService.findById(id);
        if(res==null) {
            result.setCode("0001");
            result.setMessage("Not found");
        }else {
            result.setCode("0000");
            result.setMessage("fetch data ok");
            HashMap<String, Object> resdata =new HashMap<String, Object>();
            ProductDetailDao detailDao = productDetailRepo.findById(res.getId()).orElse(null);
            resdata.put("product", res);
            resdata.put("productDetail", detailDao ==null ? new EmptyJsonBody() : detailDao);
            result.setData(resdata);
        }
           
        return result;
    }


    @PostMapping("/adddetail")
    public BaseApiResponse saveProductDetail(@RequestBody ProductDetailDao product){
        BaseApiResponse result = new BaseApiResponse();
        ProductDetailDao res  = productDetailRepo.save(product);
        if(res != null){
            result.setCode("0000");
            result.setMessage("save successfully");
            result.setData(res);
        }else {
            result.setCode("0001");
            result.setMessage("Product already exist");
        }

        return result;
    }
}
