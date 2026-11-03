package com.lhh.ticket_booking.presentation.controller;

import com.lhh.ticket_booking.application.dto.EventDetailResult;
import com.lhh.ticket_booking.application.dto.EventSummaryResult;
import com.lhh.ticket_booking.application.dto.PageResult;
import com.lhh.ticket_booking.application.port.in.GetEventDetailUseCase;
import com.lhh.ticket_booking.application.port.in.GetEventsUseCase;
import com.lhh.ticket_booking.presentation.dto.ApiResponse;
import com.lhh.ticket_booking.presentation.dto.response.CityResponse;
import com.lhh.ticket_booking.presentation.dto.response.EventDetailResponse;
import com.lhh.ticket_booking.presentation.dto.response.ShowtimeResponse;
import com.lhh.ticket_booking.presentation.mapper.EventMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {

    private final GetEventsUseCase getEventsUseCase;
    private final GetEventDetailUseCase getEventDetailUseCase;

    @GetMapping
    public ApiResponse<PageResult<EventSummaryResult>> getEvents(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        PageResult<EventSummaryResult> result = getEventsUseCase.getEvents(keyword, city, category, page, size);

        return ApiResponse.<PageResult<EventSummaryResult>>builder()
                .code(200)
                .message("Get events successfully")
                .result(result)
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<EventDetailResult> getEventById(@PathVariable Long id) {
        EventDetailResult result = getEventDetailUseCase.getEventById(id);

        return ApiResponse.<EventDetailResult>builder()
                .code(200)
                .message("Get event detail successfully")
                .result(result)
                .build();
    }
}
