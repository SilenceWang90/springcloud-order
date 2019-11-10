package com.imooc.order.controller;

import com.imooc.order.dto.OrderDTO;
import com.imooc.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/create")
    public void create(@RequestBody OrderDTO orderDTO) {
        orderService.create(orderDTO);
    }
}
