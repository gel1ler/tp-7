package ru.bmstu.tp_7.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bmstu.tp_7.config.jwt.JwtTokenUtil;
import ru.bmstu.tp_7.model.UserRole;

@RestController
@RequestMapping("/api/v2/auth")
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Operation(summary = "Авторизоваться", description = "Авторизует пользователя с ролью")
    @ApiResponse(responseCode = "200", description = "Сервис доступен")
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam UserRole role) {
        return jwtTokenUtil.generateToken(username, role);
    }
}