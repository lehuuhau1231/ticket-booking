package com.lhh.ticket_booking.domain.model;

import com.lhh.ticket_booking.domain.enums.SeatStatus;
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
public class ShowtimeSeat {
    private Long id;
    private Long showtimeId;
    private Long seatId;
    private BigDecimal price;
    @Builder.Default
    private SeatStatus status = SeatStatus.AVAILABLE;
    private LocalDateTime holdExpiresAt;
    private Long heldByUserId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
