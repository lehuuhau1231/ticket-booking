package com.lhh.ticket_booking.presentation.mapper;

import com.lhh.ticket_booking.application.dto.LoginCommand;
import com.lhh.ticket_booking.application.dto.RegisterUserCommand;
import com.lhh.ticket_booking.application.dto.UserResult;
import com.lhh.ticket_booking.presentation.dto.request.AuthRequest;
import com.lhh.ticket_booking.presentation.dto.response.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthMapper {
    RegisterUserCommand toRegisterUserCommand(AuthRequest authRequest);
    LoginCommand toLoginCommand(AuthRequest authRequest);
    UserResponse toUserResponse(UserResult userResult);
}
