package com.kosign.luna.service.product;

import java.util.ArrayList;
import java.util.List;

import com.kosign.luna.model.product.Product;
import com.kosign.luna.model.product.ProductFilter;
import com.kosign.luna.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp implements ProductService {

    private ProductRepository productRepo;

    @Autowired
    public void setProductRepo(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Page<Product> findByNameContaining(ProductFilter filter, Pageable pageable) {
        int discount = filter.getIsDiscount() ? 1 : 0;
        int stock = filter.getIsUnStock() ? 1 : 1000000;
        int endBrand = filter.getBrandId() == 0 ? 10000000 : filter.getBrandId();
        int endCategory = filter.getCategoryId() == 0 ? 10000000 : filter.getCategoryId();

        return productRepo.findByNameContainingAndPriceBetweenAndDiscountGreaterThanEqualAndStockLessThanAndRegisterDateAfterAndBrandIdBetweenAndCategoryIdBetween(filter.getName(), filter.getStartPrice(), filter.getEndPrice(), discount, stock, filter.getStartDate(), filter.getBrandId(), endBrand, filter.getCategoryId(), endCategory, pageable);
    }

    @Override
    public Product save(Product product) {
        if(productRepo.findById(product.getId()) == null){
            return productRepo.save(product);
        }else 
            return null;
    }

    @Override
    public boolean delete(int id) {
        if(productRepo.findById(id)!=null){
            productRepo.deleteById(id);
            return true;
        }else
            return false;
    }

    @Override
    public Product update(Product product) {
        if(productRepo.findById(product.getId()) != null){
            return productRepo.save(product);
        }else 
            return null;
    }
    
    @Override
    public Product findById(int id){
        return productRepo.findById(id);
    }
}
