package com.example.testest.converter;

import com.example.testest.dto.CartDTO;
import com.example.testest.dto.OrderDTO;
import com.example.testest.entity.Cart;
import com.example.testest.entity.Order;
import com.example.testest.entity.User;
import com.example.testest.exception.UserNotFoundException;
import org.springframework.stereotype.Component;
import com.example.testest.repository.ShopUserRepository;

@Component
public class OrderConverter {
    private final ShopUserRepository shopUserRepository;
    private final CartConverter cartConverter;

    public OrderConverter(CartConverter cartConverter,
                          ShopUserRepository shopUserRepository) {
        this.cartConverter = cartConverter;
        this.shopUserRepository = shopUserRepository;
    }

    public OrderDTO convertToOrderDto(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setUserId(order.getUser().getId());
        CartDTO cartDTO  = cartConverter.convertToCartDto(order.getCart());
        orderDTO.setOrderCart(cartDTO);
        return orderDTO;
    }

    public Order convertToOrderEntity(OrderDTO orderDTO) {
        Order order = new Order();
        order.setId(orderDTO.getId());
        User user = shopUserRepository.findById(orderDTO.getUserId()).orElseThrow(()-> new UserNotFoundException());
        order.setUser(user);
        Cart cart = cartConverter.convertToCartEntity(orderDTO.getOrderCart());
        order.setCart(cart);
        return order;
    }
}
