package com.lhh.ticket_booking.application.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.lhh.ticket_booking.domain.enums.ShowtimeStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
public class ShowtimeSummaryResult {
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private BigDecimal basePrice;
    private ShowtimeStatus showtimeStatus;
    private String auditoriumName;
    List<SeatTypePriceResult> seatTypePriceResults;

    public ShowtimeSummaryResult(
            Long id,
            LocalDateTime startTime,
            LocalDateTime endTime,
            BigDecimal basePrice,
            ShowtimeStatus showtimeStatus,
            String auditoriumName
    ) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.basePrice = basePrice;
        this.showtimeStatus = showtimeStatus;
        this.auditoriumName = auditoriumName;
    }
}