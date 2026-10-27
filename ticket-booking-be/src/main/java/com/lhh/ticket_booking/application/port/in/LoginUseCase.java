package com.lhh.ticket_booking.application.port.in;

import com.lhh.ticket_booking.application.dto.LoginCommand;
import com.lhh.ticket_booking.application.dto.LoginResult;

public interface LoginUseCase {
    LoginResult login(LoginCommand command);
}
