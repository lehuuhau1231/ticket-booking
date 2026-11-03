package com.lhh.ticket_booking.application.dto;

import com.lhh.ticket_booking.domain.enums.EventCategory;
import com.lhh.ticket_booking.domain.enums.EventStatus;
import com.lhh.ticket_booking.domain.enums.SeatType;
import com.lhh.ticket_booking.domain.enums.ShowtimeStatus;
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
public class EventDetailResult {
    private Long id;
    private String title;
    private String description;
    private Integer durationMinutes;
    private String posterUrl;
    private EventCategory category;
    private String cityName;
    private String locationName;
    private EventStatus status;
    List<ShowtimeSummaryResult> showtimeSummaryResults;

    public EventDetailResult(
            Long id,
            String title,
            String description,
            Integer durationMinutes,
            String posterUrl,
            EventCategory category,
            String cityName,
            String locationName,
            EventStatus status
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.durationMinutes = durationMinutes;
        this.posterUrl = posterUrl;
        this.category = category;
        this.cityName = cityName;
        this.locationName = locationName;
        this.status = status;
    }
}
