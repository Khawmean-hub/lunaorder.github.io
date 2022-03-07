package com.kosign.luna.repository;

import java.util.List;

import com.kosign.luna.model.order.Order;
import com.kosign.luna.model.order.OrderRes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository  extends JpaRepository<Order, Integer>{
    @Query(value = "SELECT o.id, o.date, o.discount, o.rate, c.name AS \"customerName\", p.name AS \"productName\", p.price FROM  orders o INNER JOIN customers c ON o.customer = c.id INNER JOIN products p ON o.product = p.id  WHERE c.name LIKE '%%' OR p.name LIKE '%%' OR p.price = cast(coalesce(nullif('',''),'0') as float8)", 
        nativeQuery = true, countQuery = "SELECT count(*) FROM  orders o INNER JOIN customers c ON o.customer = c.id INNER JOIN products p ON o.product = p.id  WHERE c.name LIKE '%%' OR p.name LIKE '%%' OR p.price = cast(coalesce(nullif('',''),'0') as float8)")
    List<OrderRes> findByPage(@Param("name") String name, Pageable pageable);

    @Query(value = "SELECT o.id, o.date, o.discount, o.rate, c.name AS \"customerName\", p.name AS \"productName\", p.price FROM  orders o INNER JOIN customers c ON o.customer = c.id INNER JOIN products p ON o.product = p.id  WHERE c.name LIKE '%%' OR p.name LIKE '%%' OR p.price = cast(coalesce(nullif('',''),'0') as float8)", 
        nativeQuery = true, countQuery = "SELECT count(*) FROM  orders o INNER JOIN customers c ON o.customer = c.id INNER JOIN products p ON o.product = p.id  WHERE c.name LIKE '%%' OR p.name LIKE '%%' OR p.price = cast(coalesce(nullif('',''),'0') as float8)")
    List<OrderRes> findTest(@Param("name") String name);

    @Query(value = "SELECT o.id, o.\"date\", o.discount, o.rate, c.\"name\" AS \"customerName\", p.\"name\" AS \"productName\", p.price FROM  orders o INNER JOIN customers c ON o.customer = c.id INNER JOIN products p ON o.product = p.id  WHERE o.\"date\" = :#{#date}", nativeQuery = true, countQuery = "SELECT count(*) from  FROM  orders o INNER JOIN customers c ON o.customer = c.id INNER JOIN products p ON o.product = p.id  WHERE o.\"date\" = :#{#date}")
    Page<OrderRes> findByDate(@Param("date") String date, Pageable pageable);

}
  