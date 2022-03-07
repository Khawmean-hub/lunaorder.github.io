package com.kosign.luna.service.order;

import java.util.List;

import com.kosign.luna.model.order.Order;
import com.kosign.luna.model.order.OrderRes;
import com.kosign.luna.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderService{

    private OrderRepository orderRepo;

    @Autowired
    public void setOrderRepo(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public List<OrderRes> findByPage(String name, Pageable pageable) {
    
        return orderRepo.findByPage(name, pageable);
    }

    @Override
    public Order save(Order order) {
        if(orderRepo.findById(order.getId()) == null){
            return orderRepo.save(order);
        }else 
            return null;
    }

    @Override
    public boolean delete(int id) {
        if(orderRepo.findById(id)!=null){
            orderRepo.deleteById(id);
            return true;
        }else
            return false;
    }

    @Override
    public Order update(Order order) {
        if(orderRepo.findById(order.getId()) != null){
            return orderRepo.save(order);
        }else 
            return null;
    }
}
