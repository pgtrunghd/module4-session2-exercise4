package com.homework.module4session2.dto;

import java.math.BigDecimal;

public record OrderResponseDTO(Long id, String customerName, BigDecimal totalAmount) {
}
