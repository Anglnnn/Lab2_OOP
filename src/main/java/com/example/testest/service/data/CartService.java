package com.example.testest.service.data;

import com.example.testest.entity.Cart;
import com.example.testest.entity.Product;
import com.example.testest.entity.User;
import com.example.testest.exception.CartNotFoundException;
import com.example.testest.exception.ProductNotFoundException;
import com.example.testest.exception.ProductNotInCartException;
import org.springframework.stereotype.Component;
import com.example.testest.repository.CartRepository;
import com.example.testest.repository.ProductRepository;


@Component
public class CartService {
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    public CartService(final ProductRepository productRepository, final CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }

    public Cart createCartForUser(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        cart.setTotalPrice(0.0);
        return cartRepository.save(cart);
    }

    public Cart addProductToCart(Long cartId, Long productId, int quantity){
        Cart cart = cartRepository.findById(cartId).orElseThrow(()-> new CartNotFoundException());
        Product product = productRepository.findById(productId).orElseThrow(()-> new ProductNotFoundException());

        cart.getItems().put(product, quantity);
        cart.setTotalPrice(cart.getTotalPrice() + product.getPrice() * quantity);
        return cartRepository.save(cart);
    }

    public Cart removeProductFromCart(Long cartId, Long productId){
        Cart cart = cartRepository.findById(cartId).orElseThrow(()-> new CartNotFoundException());
        Product product = productRepository.findById(productId).orElseThrow(()-> new ProductNotFoundException());

        if (!cart.getItems().containsKey(product)){
            throw new ProductNotInCartException();
        }

        int quantity = cart.getItems().get(product);
        cart.setTotalPrice(cart.getTotalPrice() - product.getPrice() * quantity);
        cart.getItems().remove(product);

        return cartRepository.save(cart);
    }

    public Cart increaseProductQuantity(Long cartId, Long productId, int quantity){
        Cart cart = cartRepository.findById(cartId).orElseThrow(()-> new CartNotFoundException());
        Product product = productRepository.findById(productId).orElseThrow(()-> new ProductNotFoundException());

        if (!cart.getItems().containsKey(product)){
            throw new ProductNotInCartException();
        }

        cart.getItems().put(product, cart.getItems().get(product) + quantity);
        cart.setTotalPrice(cart.getTotalPrice() + product.getPrice() * quantity);

        return cartRepository.save(cart);
    }

    public Cart getCart(Long cartId) {
        return cartRepository.findById(cartId)
                .orElseThrow(() -> new CartNotFoundException());
    }
}
