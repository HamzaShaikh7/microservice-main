package com.connect.product_service.service;


import com.connect.product_service.dto.ProductRequest;
import com.connect.product_service.dto.ProductResponse;
import com.connect.product_service.model.Product;
import com.connect.product_service.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService
{


    @Autowired
    private ProductRepository productRepository;


    public void createProduct(ProductRequest productRequest){

        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is save",product.getId());
    }

    public List<ProductResponse> getAllProduct() {

        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> mapToProductResponse(product))
                .toList();
    }


    private ProductResponse mapToProductResponse(Product product) {

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .build();
    }
}
