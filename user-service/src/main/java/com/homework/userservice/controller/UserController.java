package com.homework.userservice.controller;

import com.homework.userservice.entity.User;
import com.homework.userservice.repository.UserRepository;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserRepository userRepository;
    private final JdbcTemplate jdbcTemplate;
    private final DataSource dataSource;

    public UserController(UserRepository userRepository, JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.userRepository = userRepository;
        this.jdbcTemplate = jdbcTemplate;
        this.dataSource = dataSource;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    /** Thông tin kết nối DB của service: chứng minh mỗi service dùng database và connection pool riêng. */
    @GetMapping("/db-info")
    public Map<String, Object> dbInfo() {
        return Map.of(
                "service", "user-service",
                "database", jdbcTemplate.queryForObject("select current_database()", String.class),
                "backendPid", jdbcTemplate.queryForObject("select pg_backend_pid()", Integer.class),
                "dataSourceId", System.identityHashCode(dataSource));
    }
}
