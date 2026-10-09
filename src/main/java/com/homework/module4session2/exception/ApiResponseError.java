package com.homework.module4session2.exception;

import java.time.LocalDateTime;

public record ApiResponseError(LocalDateTime timestamp, int status, String error, String message) {
}
