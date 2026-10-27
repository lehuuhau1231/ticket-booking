package com.lhh.ticket_booking.application.mapper;

import com.lhh.ticket_booking.application.dto.UserResult;
import com.lhh.ticket_booking.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserAppMapper {
    UserResult toUserResult(User user);
}
