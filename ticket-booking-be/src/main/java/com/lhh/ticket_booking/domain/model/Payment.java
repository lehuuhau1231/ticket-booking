package com.lhh.ticket_booking.domain.model;

import com.lhh.ticket_booking.domain.enums.PaymentMethod;
import com.lhh.ticket_booking.domain.enums.PaymentStatus;
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
public class Payment {
    private Long id;
    private Long bookingId;
    private String transactionCode;
    private PaymentMethod paymentMethod;
    private BigDecimal amount;
    @Builder.Default
    private PaymentStatus status = PaymentStatus.INITIATED;
    private LocalDateTime paidAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
