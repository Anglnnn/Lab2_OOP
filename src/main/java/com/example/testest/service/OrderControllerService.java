package com.example.testest.service;

import com.example.testest.converter.CartConverter;
import com.example.testest.converter.OrderConverter;
import com.example.testest.dto.CartDTO;
import com.example.testest.dto.OrderDTO;
import com.example.testest.entity.Cart;
import com.example.testest.entity.Order;
import com.example.testest.service.data.CartService;
import org.springframework.stereotype.Service;
import com.example.testest.service.data.OrderService;

@Service
public class OrderControllerService {
    private final OrderService orderService;
    private final OrderConverter orderConverter;
    private final CartConverter cartConverter;
    private final CartService cartService;

    public OrderControllerService(OrderService orderService,
                                  OrderConverter orderConverter,
                                  CartConverter cartConverter,
                                  CartService cartService) {
        this.orderService = orderService;
        this.orderConverter = orderConverter;
        this.cartConverter = cartConverter;
        this.cartService = cartService;
    }

    public OrderDTO createOrder(Long userId) {
        Cart cart = cartService.getCart(userId);
        Order order = orderService.createOrder(userId, cart);
        return orderConverter.convertToOrderDto(order);
    }
}
