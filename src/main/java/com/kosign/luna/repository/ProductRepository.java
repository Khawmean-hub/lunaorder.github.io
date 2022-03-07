package com.kosign.luna.repository;

import java.sql.Date;

import com.kosign.luna.model.product.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    Page<Product> findByNameContainingAndPriceBetweenAndDiscountGreaterThanEqualAndStockLessThanAndRegisterDateAfterAndBrandIdBetweenAndCategoryIdBetween(String name, Float price, Float price2, int discount, int stock ,Date date, int brandId, int brandId2, int categoryId, int categoryId2 ,Pageable pageable);
    Product findById(int id);
}
