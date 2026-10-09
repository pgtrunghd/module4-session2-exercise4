package com.homework.inventoryservice.controller;

import com.homework.inventoryservice.entity.Product;
import com.homework.inventoryservice.repository.ProductRepository;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductRepository productRepository;
    private final JdbcTemplate jdbcTemplate;
    private final DataSource dataSource;

    public ProductController(ProductRepository productRepository, JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.productRepository = productRepository;
        this.jdbcTemplate = jdbcTemplate;
        this.dataSource = dataSource;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    /** Thông tin kết nối DB của service: chứng minh mỗi service dùng database và connection pool riêng. */
    @GetMapping("/db-info")
    public Map<String, Object> dbInfo() {
        return Map.of(
                "service", "inventory-service",
                "database", jdbcTemplate.queryForObject("select current_database()", String.class),
                "backendPid", jdbcTemplate.queryForObject("select pg_backend_pid()", Integer.class),
                "dataSourceId", System.identityHashCode(dataSource));
    }
}
