package com.kosign.luna.repository;

import com.kosign.luna.model.product.ProductDetailDao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepo extends CrudRepository<ProductDetailDao, Integer> {
    
}
