package com.lhh.ticket_booking.presentation.controller;

import com.lhh.ticket_booking.application.dto.UserResult;
import com.lhh.ticket_booking.application.port.in.GetCurrentUserUseCase;
import com.lhh.ticket_booking.presentation.dto.ApiResponse;
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
    public ApiResponse<UserResult> getUser() {
        UserResult result = getCurrentUserUseCase.getCurrentUser();

        return ApiResponse.<UserResult>builder()
                .message("Get user successfully")
                .result(result)
                .build();
    }
}
