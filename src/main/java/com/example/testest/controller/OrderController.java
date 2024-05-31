package com.example.testest.controller;


import com.example.testest.dto.OrderDTO;
import org.springframework.web.bind.annotation.*;
import com.example.testest.service.OrderControllerService;

@RestController
@CrossOrigin
public class OrderController {
    private OrderControllerService orderControllerService;

    public OrderController (OrderControllerService orderControllerService) {
        this.orderControllerService = orderControllerService;
    }

    @PostMapping(value = "/orders/{userId}")
    public OrderDTO createOrder(@PathVariable Long userId) {
        return orderControllerService.createOrder(userId);
    }
}
