package com.lhh.ticket_booking.application.port.out;

import com.lhh.ticket_booking.domain.model.User;

public interface TokenProviderPort {
    String generateToken(User user);
    boolean validateToken(String token);
    String getRoleFromToken(String token);
    String getUserIdFromToken(String token);
}
