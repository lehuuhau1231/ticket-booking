package com.lhh.ticket_booking.presentation.controller;

import com.lhh.ticket_booking.application.dto.UserResult;
import com.lhh.ticket_booking.application.port.in.GetCurrentUserUseCase;
import com.lhh.ticket_booking.presentation.dto.ApiResponse;
import com.lhh.ticket_booking.presentation.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final GetCurrentUserUseCase getCurrentUserUseCase;

    @GetMapping("/user")
    public ApiResponse<UserResponse> getUser() {
        UserResult result = getCurrentUserUseCase.getCurrentUser();

        UserResponse userResponse = UserResponse.builder()
                .id(result.getId())
                .email(result.getEmail())
                .role(result.getRole())
                .build();

        return ApiResponse.<UserResponse>builder()
                .message("Get user successfully")
                .result(userResponse)
                .build();
    }
}
