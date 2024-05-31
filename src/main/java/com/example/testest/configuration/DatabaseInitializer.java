package com.example.testest.configuration;

import com.example.testest.entity.*;
import com.example.testest.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
/*
@Component
public class DatabaseInitializer implements CommandLineRunner {
    @Autowired
    private ShopUserRepository shopUserRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private BlacklistRepository blacklistRepository;


    @Override
    public void run(String... args) throws Exception {
        // Створення продуктів
        Product product1 = new Product();
        product1.setName("Product 1");
        product1.setDescription("Description 1");
        product1.setPrice(100.0);
        product1.setQuantity(10);
        product1.setImageUrl("https://content.rozetka.com.ua/goods/images/big/334492324.jpg");

        Product product2 = new Product();
        product2.setName("Product 2");
        product2.setDescription("Description 2");
        product2.setPrice(200.0);
        product2.setQuantity(20);
        product2.setImageUrl("https://content1.rozetka.com.ua/goods/images/big_tile/364834251.jpg");

        productRepository.save(product1);
        productRepository.save(product2);

        // Створення користувача
        User user = new User();
        user.setName("John Doe");
        user.setLogin("johndoe");
        shopUserRepository.save(user);

        // Створення кошика
        Cart cart = new Cart();
        cart.setUser(user);
        Map<Product, Integer> items = new HashMap<>();
        items.put(product1, 1);
        items.put(product2, 2);
        cart.setItems(items);
        cart.setTotalPrice(500.0);

        cartRepository.save(cart);

        user.setCart(cart);


        // Створення замовлення
        Order order = new Order();
        order.setUser(user);
        order.setCart(cart);
        order.setOrderDate(LocalDateTime.now());

        orderRepository.save(order);

        // Створення чорного списку
        Blacklist blacklist = new Blacklist();
        blacklist.setUser(user);

        blacklistRepository.save(blacklist);
    }
}
*/