package com.example.diplom3.controller;

import com.example.diplom3.dto.JwtAuthenticationResponse;
import com.example.diplom3.dto.SignInRequest;
import com.example.diplom3.dto.SignUpRequest;
import com.example.diplom3.model.User;
import com.example.diplom3.security.AuthenticationService;
import com.example.diplom3.security.JwtService;
import com.example.diplom3.security.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Аутентификация")
public class AuthController {
    private final AuthenticationService authenticationService;

    private final UserService userService;

    @Operation(summary = "Регистрация пользователя")
    @ApiResponse(responseCode = "200", description = "Регистрация прошла успешно")
    @ApiResponse(responseCode = "400", description = "Указаны некорректные параметры")
    @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    @PostMapping("/sign-up")
    public JwtAuthenticationResponse signUp(@RequestBody @Valid SignUpRequest request) {

        return authenticationService.signUp(request);
    }

    @Operation(summary = "Регистрация пользователя")
    @ApiResponse(responseCode = "200", description = "Авторизация прошла успешно")
    @ApiResponse(responseCode = "400", description = "Указаны некорректные параметры")
    @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    @PostMapping("/sign-in")
    public JwtAuthenticationResponse signIn(@RequestBody @Valid SignInRequest request) {
        return authenticationService.signIn(request);
    }
}