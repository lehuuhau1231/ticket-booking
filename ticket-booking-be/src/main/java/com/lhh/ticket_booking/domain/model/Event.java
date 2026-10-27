package com.lhh.ticket_booking.domain.model;

import com.lhh.ticket_booking.domain.enums.EventStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {
    private Long id;
    private String title;
    private String description;
    private Integer durationMinutes;
    @Builder.Default
    private EventStatus status = EventStatus.UPCOMING;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
