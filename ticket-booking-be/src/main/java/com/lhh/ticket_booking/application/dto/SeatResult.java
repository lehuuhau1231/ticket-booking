package com.lhh.ticket_booking.application.dto;

import com.lhh.ticket_booking.domain.enums.SeatStatus;
import com.lhh.ticket_booking.domain.enums.SeatType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatResult {
//    seat entity
    private Long seatId;
    private Integer columnIndex;
    private Integer rowIndex;
    private String seatRow;
    private Integer seatNumber;
    private String seatCode;
    private SeatType seatType;

//    showtime_seats entity
    private BigDecimal price;
    private SeatStatus status;
    private LocalDateTime holdExpiresAt;
}
