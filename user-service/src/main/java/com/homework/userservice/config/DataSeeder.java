package com.homework.userservice.config;

import com.homework.userservice.entity.User;
import com.homework.userservice.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedUsers(UserRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(User.builder().username("alice").email("alice@example.com").build());
                repository.save(User.builder().username("bob").email("bob@example.com").build());
            }
        };
    }
}
