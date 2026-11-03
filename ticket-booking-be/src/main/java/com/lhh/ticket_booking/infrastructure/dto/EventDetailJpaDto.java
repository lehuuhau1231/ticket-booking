package com.lhh.ticket_booking.infrastructure.dto;

import com.lhh.ticket_booking.application.dto.ShowtimeSummaryResult;
import com.lhh.ticket_booking.domain.enums.EventCategory;
import com.lhh.ticket_booking.domain.enums.EventStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class EventDetailJpaDto {
    private Long id;
    private String title;
    private String description;
    private Integer durationMinutes;
    private String posterUrl;
    private EventCategory category;
    private String cityName;
    private String locationName;
    private LocalDateTime startDate;
    private BigDecimal minPrice;
    private EventStatus status;
    private List<String> artists;
    private List<ShowtimeSummaryResult> showtimes;
}
