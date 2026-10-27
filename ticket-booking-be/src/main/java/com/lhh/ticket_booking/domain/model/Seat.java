package com.lhh.ticket_booking.domain.model;

import com.lhh.ticket_booking.domain.enums.SeatType;
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
public class Seat {
    private Long id;
    private Long auditoriumId;
    private String seatRow;
    private Integer seatNumber;
    private String seatCode;
    @Builder.Default
    private SeatType seatType = SeatType.STANDARD;
    private Integer rowIndex;
    private Integer columnIndex;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
