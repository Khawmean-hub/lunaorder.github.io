package com.kosign.luna.repository;

import com.kosign.luna.model.customer.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{
    Page<Customer> findByNameContaining(String name, Pageable pageable);
    Customer findById(int id);
    Customer findByUserId(int id);

    @Query(value = "SELECT * FROM customers WHERE user_id IN (SELECT users_id FROM group_permission WHERE group_id = :groupId)", nativeQuery = true)
    List<Customer> findAllCustomersJpaQuery(@Param("groupId") Integer groupId);
}
