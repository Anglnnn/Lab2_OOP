package com.example.testest.service;


import com.example.testest.converter.ProductConverter;
import com.example.testest.dto.ProductDTO;
import com.example.testest.entity.Product;
import org.springframework.stereotype.Service;
import com.example.testest.service.data.ProductService;

import java.util.List;

@Service
public class ProductControllerService {
    private final ProductService productService;
    private final ProductConverter productConverter;

    public ProductControllerService(ProductService productService, ProductConverter productConverter) {
        this.productService = productService;
        this.productConverter = productConverter;
    }

    public List<ProductDTO> findAll() {
        return productConverter.convertToListDTO(productService.findAll());
    }

    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = productConverter.convertToEntity(productDTO);
        Product updatedProduct = productService.addProduct(product);
        return productConverter.convertToProductDTO(updatedProduct);
    }

    public ProductDTO updateProduct(ProductDTO productDTO) {
        Product product = productConverter.convertToEntity(productDTO);
        Product updatedProduct = productService.updateProduct(product);
        return productConverter.convertToProductDTO(updatedProduct);
    }

    public void deleteProduct(Long id) {
        productService.deleteProduct(id);
    }
}
