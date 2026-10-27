package com.lhh.ticket_booking.domain.model;

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
public class BookingItem {
    private Long id;
    private Long bookingId;
    private Long showtimeSeatId;
    private BigDecimal price;
    private String ticketCode;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
