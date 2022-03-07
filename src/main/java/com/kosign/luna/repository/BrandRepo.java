package com.kosign.luna.repository;

import com.kosign.luna.model.brand.Brand;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepo extends CrudRepository<Brand, Integer>{
    Page<Brand> findAllByNameContaining(String name, Pageable page);
}
