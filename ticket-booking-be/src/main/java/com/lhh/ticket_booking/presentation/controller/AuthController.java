package com.lhh.ticket_booking.presentation.controller;

import com.lhh.ticket_booking.application.dto.LoginCommand;
import com.lhh.ticket_booking.application.dto.LoginResult;
import com.lhh.ticket_booking.application.dto.RegisterUserCommand;
import com.lhh.ticket_booking.application.port.in.LoginUseCase;
import com.lhh.ticket_booking.application.port.in.RegisterUserUseCase;
import com.lhh.ticket_booking.presentation.dto.ApiResponse;
import com.lhh.ticket_booking.presentation.dto.request.AuthRequest;
import com.lhh.ticket_booking.presentation.dto.response.LoginResponse;
import com.lhh.ticket_booking.presentation.dto.response.UserResponse;
import com.lhh.ticket_booking.presentation.mapper.AuthMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final RegisterUserUseCase registerUserUseCase;
    private final LoginUseCase loginUseCase;
    private final AuthMapper authMapper;

    @PostMapping("/register")
    public ApiResponse<Void> register(@RequestBody @Valid AuthRequest request) {
        RegisterUserCommand registerUserCommand = authMapper.toRegisterUserCommand(request);
        registerUserUseCase.register(registerUserCommand);

        return ApiResponse.<Void>builder()
                .message("User registered successfully")
                .build();
    }

    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(@RequestBody @Valid AuthRequest request) {
        LoginCommand loginCommand = authMapper.toLoginCommand(request);
        LoginResult result = loginUseCase.login(loginCommand);

        UserResponse userResponse = authMapper.toUserResponse(result.getUser());

        LoginResponse loginResponse = LoginResponse.builder()
                .userResponse(userResponse)
                .token(result.getToken())
                .build();

        return ApiResponse.<LoginResponse>builder()
                .message("Login successfully")
                .result(loginResponse)
                .build();
    }
}
