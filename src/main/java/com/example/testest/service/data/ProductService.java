package com.example.testest.service.data;

import com.example.testest.entity.Product;
import org.springframework.stereotype.Component;
import com.example.testest.repository.ProductRepository;

import java.util.List;
import java.util.Optional;


@Component
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public Optional<Product> findProductById(Long id){
        return productRepository.findById(id);
    }
}
