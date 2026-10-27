package com.lhh.ticket_booking.domain.model;

import com.lhh.ticket_booking.domain.enums.ShowtimeStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Showtime {
    private Long id;
    private Long eventId;
    private Long auditoriumId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private BigDecimal basePrice;
    @Builder.Default
    private ShowtimeStatus status = ShowtimeStatus.SCHEDULED;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
