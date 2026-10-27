package com.lhh.ticket_booking.domain.model;

import com.lhh.ticket_booking.domain.enums.UserRole;
import com.lhh.ticket_booking.domain.enums.UserStatus;
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
public class User {
    private Long id;
    private String email;
    private String password;
    @Builder.Default
    private UserRole role = UserRole.CUSTOMER;
    @Builder.Default
    private UserStatus status = UserStatus.ACTIVE;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
