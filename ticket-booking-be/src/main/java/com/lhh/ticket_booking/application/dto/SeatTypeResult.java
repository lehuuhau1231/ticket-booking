package com.lhh.ticket_booking.application.dto;

import com.lhh.ticket_booking.domain.enums.SeatType;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatTypeResult {
    private BigDecimal price;
    private SeatType seatType;
}
