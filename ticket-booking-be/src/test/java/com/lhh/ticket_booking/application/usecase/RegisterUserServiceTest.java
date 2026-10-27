package com.lhh.ticket_booking.application.usecase;

import com.lhh.ticket_booking.application.dto.RegisterUserCommand;
import com.lhh.ticket_booking.application.port.out.IdGeneratorPort;
import com.lhh.ticket_booking.application.port.out.PasswordEncoderPort;
import com.lhh.ticket_booking.domain.exception.AppException;
import com.lhh.ticket_booking.domain.exception.ErrorCode;
import com.lhh.ticket_booking.domain.model.User;
import com.lhh.ticket_booking.domain.repository.UserRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RegisterUserServiceTest {

    @Mock
    private UserRepositoryPort userRepositoryPort;

    @Mock
    private PasswordEncoderPort passwordEncoderPort;

    @Mock
    private IdGeneratorPort idGeneratorPort;

    @InjectMocks
    private RegisterUserService registerUserService;

    private RegisterUserCommand command;

    @BeforeEach
    void setUp() {
        command = RegisterUserCommand.builder()
                .email("test@example.com")
                .password("secret123")
                .build();
    }

    @Test
    void register_WhenEmailAlreadyExists_ShouldThrowAppException() {
        when(userRepositoryPort.existsByEmail("test@example.com")).thenReturn(true);

        AppException exception = assertThrows(AppException.class, () -> registerUserService.register(command));

        assertEquals(ErrorCode.USER_EXISTED, exception.getErrorCode());
        verify(userRepositoryPort, never()).save(any());
    }

    @Test
    void register_WhenValidRequest_ShouldSaveUser() {
        when(userRepositoryPort.existsByEmail("test@example.com")).thenReturn(false);
        when(idGeneratorPort.generateId()).thenReturn(1001L);
        when(passwordEncoderPort.encode("secret123")).thenReturn("encoded_pass");

        registerUserService.register(command);

        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
        verify(userRepositoryPort).save(captor.capture());

        User savedUser = captor.getValue();
        assertEquals(1001L, savedUser.getId());
        assertEquals("test@example.com", savedUser.getEmail());
        assertEquals("encoded_pass", savedUser.getPassword());
    }
}
