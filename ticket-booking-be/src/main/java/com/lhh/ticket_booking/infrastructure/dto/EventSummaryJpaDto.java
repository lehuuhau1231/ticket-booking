package com.lhh.ticket_booking.infrastructure.dto;

import com.lhh.ticket_booking.domain.enums.EventCategory;
import com.lhh.ticket_booking.domain.enums.EventStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class EventSummaryJpaDto {
    private Long id;
    private String title;
    private String posterUrl;
    private EventCategory category;
    private EventStatus eventStatus;
    private String cityName;
    private LocalDateTime startDate;
}
