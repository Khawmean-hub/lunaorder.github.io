package com.kosign.luna.service.product;

import com.kosign.luna.model.product.Product;
import com.kosign.luna.model.product.ProductFilter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> findByNameContaining(ProductFilter filter, Pageable pageable);
    Product save(Product product);
    boolean delete(int id);
    Product update(Product product);
    Product findById(int id);
}
