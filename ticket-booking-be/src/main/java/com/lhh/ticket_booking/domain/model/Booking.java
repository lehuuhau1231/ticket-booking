package com.lhh.ticket_booking.domain.model;

import com.lhh.ticket_booking.domain.enums.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {
    private Long id;
    private String bookingCode;
    private Long userId;
    private BigDecimal totalAmount;
    @Builder.Default
    private BookingStatus status = BookingStatus.PENDING;
    private LocalDateTime expiresAt;
    @Builder.Default
    private List<BookingItem> items = new ArrayList<>();
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
