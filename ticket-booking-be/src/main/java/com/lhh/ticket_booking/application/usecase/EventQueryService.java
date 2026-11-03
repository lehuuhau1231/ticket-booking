package com.lhh.ticket_booking.application.usecase;

import com.lhh.ticket_booking.application.dto.*;
import com.lhh.ticket_booking.application.port.in.GetEventDetailUseCase;
import com.lhh.ticket_booking.application.port.in.GetEventsUseCase;
import com.lhh.ticket_booking.domain.enums.EventCategory;
import com.lhh.ticket_booking.domain.exception.AppException;
import com.lhh.ticket_booking.domain.exception.ErrorCode;
import com.lhh.ticket_booking.domain.repository.EventRepositoryPort;
import com.lhh.ticket_booking.domain.repository.ShowtimeRepositoryPort;
import com.lhh.ticket_booking.domain.repository.ShowtimeSeatRepositoryPort;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EventQueryService implements GetEventsUseCase, GetEventDetailUseCase {

    private final EventRepositoryPort eventRepositoryPort;
    private final ShowtimeRepositoryPort showtimeRepositoryPort;
    private final ShowtimeSeatRepositoryPort showtimeSeatRepositoryPort;

    @Override
    public PageResult<EventSummaryResult> getEvents(String keyword, String city, String categoryStr, int page, int size) {
        String trimmedKeyword = (keyword != null && !keyword.trim().isEmpty()) ? keyword.trim() : null;
        String cityCode = (city != null && !city.trim().isEmpty() && !"all".equalsIgnoreCase(city.trim()))
                ? city.trim() : null;

        EventCategory category = null;
        if (categoryStr != null && !categoryStr.trim().isEmpty() && !"ALL".equalsIgnoreCase(categoryStr.trim())) {
            try {
                category = EventCategory.valueOf(categoryStr.trim().toUpperCase());
            } catch (IllegalArgumentException ignored) {
                throw new AppException(ErrorCode.INVALID_CATEGORY);
            }
        }

        int pageIndex = Math.max(0, page);
        int pageSize = size > 0 ? size : 10;
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Page<EventSummaryResult> eventPage = eventRepositoryPort.searchEvents(trimmedKeyword, cityCode, category, pageable);

        if (eventPage.isEmpty()) {
            return PageResult.<EventSummaryResult>builder()
                    .content(Collections.emptyList())
                    .page(pageIndex)
                    .size(pageSize)
                    .totalElements(eventPage.getTotalElements())
                    .totalPages(eventPage.getTotalPages())
                    .last(eventPage.isLast())
                    .build();
        }

        return PageResult.<EventSummaryResult>builder()
                .content(eventPage.getContent())
                .page(pageIndex)
                .size(pageSize)
                .totalElements(eventPage.getTotalElements())
                .totalPages(eventPage.getTotalPages())
                .last(eventPage.isLast())
                .build();
    }

    @Override
    public EventDetailResult getEventById(Long id) {
        EventDetailResult eventDetailResult = eventRepositoryPort.findByEventId(id);

        List<ShowtimeSummaryResult> showtimes = showtimeRepositoryPort.findShowtimeByEventId(id);
        List<Long> showtimeIds = showtimes.stream().map(ShowtimeSummaryResult::getId).toList();

        List<SeatTypePriceResult> seatTypePriceResults = showtimeIds.isEmpty()
                ? List.of()
                : showtimeSeatRepositoryPort.getSeatTypeByShowtimeId(showtimeIds);

        Map<Long, List<SeatTypePriceResult>> seatTypePriceMap = seatTypePriceResults.stream()
                .collect(Collectors.groupingBy(SeatTypePriceResult::getShowtimeId));

        showtimes.forEach(showtime ->
                showtime.setSeatTypePriceResults(seatTypePriceMap.getOrDefault(showtime.getId(), List.of())));

        eventDetailResult.setShowtimeSummaryResults(showtimes);

        return eventDetailResult;
    }
}
