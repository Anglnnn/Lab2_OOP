package com.example.testest.service.data;

import com.example.testest.entity.Cart;
import com.example.testest.entity.Order;
import com.example.testest.entity.User;
import com.example.testest.exception.UserInBlacklistException;
import com.example.testest.exception.UserNotFoundException;
import org.springframework.stereotype.Component;
import com.example.testest.repository.OrderRepository;
import com.example.testest.repository.ShopUserRepository;

import java.time.LocalDateTime;

@Component
public class OrderService {
    private final OrderRepository orderRepository;
    private final ShopUserRepository shopUserRepository;

    public OrderService(OrderRepository orderRepository, ShopUserRepository shopUserRepository) {
        this.orderRepository = orderRepository;
        this.shopUserRepository = shopUserRepository;
    }

    public Order createOrder(Long userId, Cart cart) {
        User user = shopUserRepository.findById(userId).orElseThrow(()-> new UserNotFoundException());
        if (user.getBlacklist() != null){
            throw new UserInBlacklistException("User is in blacklist and cannot make orders.");
        }
        Order order = new Order();
        order.setUser(user);
        order.setCart(cart);
        order.setOrderDate(LocalDateTime.now());

        return orderRepository.save(order);
    }

}
