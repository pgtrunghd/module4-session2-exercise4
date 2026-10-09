package com.homework.module4session2.service;

import com.homework.module4session2.dto.ProductResponseDTO;
import com.homework.module4session2.entity.ProductEntity;
import com.homework.module4session2.exception.ResourceNotFoundException;
import com.homework.module4session2.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDTO getById(Long id) {
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product với ID " + id + " không tồn tại trên hệ thống!"));
        return toResponse(product);
    }

    private ProductResponseDTO toResponse(ProductEntity product) {
        return new ProductResponseDTO(product.getId(), product.getName(), product.getSellPrice());
    }
}
