package com.homework.module4session2.service;

import com.homework.module4session2.dto.OrderResponseDTO;
import com.homework.module4session2.entity.Order;
import com.homework.module4session2.exception.ResourceNotFoundException;
import com.homework.module4session2.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String healthCheck() {
        return "Order Service is Up";
    }

    public OrderResponseDTO getById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order với ID " + id + " không tồn tại trên hệ thống!"));
        return new OrderResponseDTO(order.getId(), order.getCustomerName(), order.getTotalAmount());
    }
}
