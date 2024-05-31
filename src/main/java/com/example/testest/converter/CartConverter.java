package com.example.testest.converter;


import com.example.testest.dto.CartDTO;
import com.example.testest.dto.CartItemDTO;
import com.example.testest.entity.Cart;
import com.example.testest.entity.Product;
import com.example.testest.entity.User;
import com.example.testest.exception.UserNotFoundException;
import org.springframework.stereotype.Component;
import com.example.testest.repository.ShopUserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CartConverter {

    private final ShopUserRepository shopUserRepository;

    public CartConverter(ShopUserRepository shopUserRepository) {
        this.shopUserRepository = shopUserRepository;
    }

    public CartDTO convertToCartDto(Cart cart) {
        CartDTO cartDTO = new CartDTO();
        cartDTO.setId(cart.getId());
        cartDTO.setUserId(cart.getUser().getId());
        cartDTO.setTotalPrice(cart.getTotalPrice());

        List<CartItemDTO> cartItems = cart.getItems().entrySet().stream()
                .map(entry -> {
                    CartItemDTO item = new CartItemDTO();
                    item.setProductId(entry.getKey().getId());
                    item.setQuantity(entry.getValue());
                    return item;
                })
                .collect(Collectors.toList());

        cartDTO.setCartItems(cartItems);
        return cartDTO;
    }

    public Cart convertToCartEntity(CartDTO cartDTO) {
        Cart cart = new Cart();
        cart.setId(cartDTO.getId());
        User user = shopUserRepository.findById(cartDTO.getUserId()).orElseThrow(()-> new UserNotFoundException());
        cart.setUser(user);
        cart.setTotalPrice(cartDTO.getTotalPrice());

        Map<Product, Integer> items = new HashMap<>();
        for (CartItemDTO item : cartDTO.getCartItems()) {
            Product product = new Product();
            product.setId(item.getProductId());
            items.put(product, item.getQuantity());
        }
        cart.setItems(items);
        return cart;
    }

}
