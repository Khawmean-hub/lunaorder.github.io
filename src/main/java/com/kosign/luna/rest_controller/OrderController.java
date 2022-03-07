package com.kosign.luna.rest_controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.kosign.luna.model.BaseApiResponse;
import com.kosign.luna.model.PageReq;
import com.kosign.luna.model.order.OrderRes;
import com.kosign.luna.model.order.OrderResponse;
import com.kosign.luna.service.order.OrderService;
import com.kosign.luna.util.ApiMapperUtile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/order")
@Api(tags = "Order", value = "order", description = "order for")
public class OrderController {

    private OrderService orderService;
    private ApiMapperUtile apiMap;

    @Autowired
    public void setApiMap(ApiMapperUtile apiMap) {
        this.apiMap = apiMap;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/")
    public BaseApiResponse findAll(@RequestParam(defaultValue = "") String search, PageReq pageReq){
        BaseApiResponse result = new BaseApiResponse();
            result.setCode("0000");
            result.setMessage("fetch data ok");
            Pageable page = PageRequest.of(0, 10);
            result.setData(orderService.findByPage(search, page).stream().map(OrderResponse::new).collect(Collectors.toList()));
        return result;
    }
}
