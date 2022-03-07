package com.kosign.luna.service.order;

import java.util.List;

import com.kosign.luna.model.order.Order;
import com.kosign.luna.model.order.OrderRes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface OrderService {

    List<OrderRes> findByPage(@Param("name") String name, Pageable pageable);
    Order save(Order order);
    boolean delete(int id);
    Order update(Order order);
}
