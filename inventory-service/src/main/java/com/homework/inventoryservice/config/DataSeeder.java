package com.homework.inventoryservice.config;

import com.homework.inventoryservice.entity.Product;
import com.homework.inventoryservice.repository.ProductRepository;
import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedProducts(ProductRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(Product.builder().name("Ban phim co").price(new BigDecimal("750000")).quantity(100).build());
                repository.save(Product.builder().name("Chuot khong day").price(new BigDecimal("350000")).quantity(50).build());
            }
        };
    }
}
