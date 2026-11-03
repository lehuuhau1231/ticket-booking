package com.lhh.ticket_booking.application.dto;

import com.lhh.ticket_booking.domain.enums.EventCategory;
import com.lhh.ticket_booking.domain.enums.EventStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventSummaryResult {
    private Long id;
    private String title;
    private String posterUrl;
    private EventCategory category;
    private EventStatus eventStatus;
    private String cityName;
    private LocalDateTime startDate;
}
