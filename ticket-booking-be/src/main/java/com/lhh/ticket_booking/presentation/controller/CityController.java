package com.lhh.ticket_booking.presentation.controller;

import com.lhh.ticket_booking.application.dto.CityResult;
import com.lhh.ticket_booking.application.port.in.GetCitiesUseCase;
import com.lhh.ticket_booking.presentation.dto.ApiResponse;
import com.lhh.ticket_booking.presentation.dto.response.CityResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
public class CityController {

    private final GetCitiesUseCase getCitiesUseCase;

    @GetMapping
    public ApiResponse<List<CityResult>> getCities() {
        List<CityResult> results = getCitiesUseCase.getCities();

        return ApiResponse.<List<CityResult>>builder()
                .code(200)
                .message("Get cities successfully")
                .result(results)
                .build();
    }
}
