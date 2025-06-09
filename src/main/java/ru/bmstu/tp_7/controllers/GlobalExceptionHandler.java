package ru.bmstu.tp_7.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;
import java.util.NoSuchElementException;


@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException ex) {
        return new ResponseEntity<>(
                Map.of("Внутренняя ошибка сервера: ", ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Map<String, String>> handleSpringAccessDeniedException(AccessDeniedException ex) {
        return new ResponseEntity<>(
                Map.of("Ошибка доступа: ", ex.getMessage()),
                HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleResourceNotFoundException(NoSuchElementException ex) {
        return new ResponseEntity<>("Ресурс не найден", HttpStatus.NOT_FOUND);
    }
}