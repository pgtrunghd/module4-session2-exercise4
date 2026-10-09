package com.homework.module4session2.config;

import com.homework.module4session2.entity.ProductEntity;
import com.homework.module4session2.repository.ProductRepository;
import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedProducts(ProductRepository repository) {
        return args -> {
            if (repository.count() > 0) {
                return;
            }
            repository.save(ProductEntity.builder()
                .name("Ban phim co")
                .sku("KB-001")
                .importPrice(new BigDecimal("500000"))
                .sellPrice(new BigDecimal("750000"))
                .stockQuantity(100)
                .build());
        };
    }
}
