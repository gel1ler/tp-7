package ru.bmstu.tp_7.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}