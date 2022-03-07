package com.kosign.luna.model.order;

import java.sql.Date;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import org.springframework.beans.factory.annotation.Value;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public interface OrderRes {
    @Value("#{target.id}")
    int id();

    @Value("#{target.customerName}")
    String customrName();
    
    @Value("#{target.productName}")
    String productName();

    @Value("#{target.price}")
    float price();

    @Value("#{target.discount}")
    int discount();
    
    @Value("#{target.rate}")
    float rate();

    @Value("#{target.date}")
    String date();
}
