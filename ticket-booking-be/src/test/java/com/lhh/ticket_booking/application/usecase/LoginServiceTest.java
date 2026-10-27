package com.lhh.ticket_booking.application.usecase;

import com.lhh.ticket_booking.application.dto.LoginCommand;
import com.lhh.ticket_booking.application.dto.LoginResult;
import com.lhh.ticket_booking.application.port.out.PasswordEncoderPort;
import com.lhh.ticket_booking.application.port.out.TokenProviderPort;
import com.lhh.ticket_booking.domain.enums.UserRole;
import com.lhh.ticket_booking.domain.enums.UserStatus;
import com.lhh.ticket_booking.domain.exception.AppException;
import com.lhh.ticket_booking.domain.exception.ErrorCode;
import com.lhh.ticket_booking.domain.model.User;
import com.lhh.ticket_booking.domain.repository.UserRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoginServiceTest {

    @Mock
    private UserRepositoryPort userRepositoryPort;

    @Mock
    private PasswordEncoderPort passwordEncoderPort;

    @Mock
    private TokenProviderPort tokenProviderPort;

    @InjectMocks
    private LoginService loginService;

    private LoginCommand command;
    private User mockUser;

    @BeforeEach
    void setUp() {
        command = LoginCommand.builder()
                .email("test@example.com")
                .password("secret123")
                .build();

        mockUser = User.builder()
                .id(1L)
                .email("test@example.com")
                .password("encoded_pass")
                .role(UserRole.CUSTOMER)
                .status(UserStatus.ACTIVE)
                .build();
    }

    @Test
    void login_WhenUserNotFound_ShouldThrowAppException() {
        when(userRepositoryPort.findByEmail("test@example.com")).thenReturn(Optional.empty());

        AppException exception = assertThrows(AppException.class, () -> loginService.login(command));

        assertEquals(ErrorCode.USER_NOT_FOUND, exception.getErrorCode());
    }

    @Test
    void login_WhenPasswordMismatch_ShouldThrowAppException() {
        when(userRepositoryPort.findByEmail("test@example.com")).thenReturn(Optional.of(mockUser));
        when(passwordEncoderPort.matches("secret123", "encoded_pass")).thenReturn(false);

        AppException exception = assertThrows(AppException.class, () -> loginService.login(command));

        assertEquals(ErrorCode.INVALID_PASSWORD, exception.getErrorCode());
    }

    @Test
    void login_WhenValidCredentials_ShouldReturnLoginResult() {
        when(userRepositoryPort.findByEmail("test@example.com")).thenReturn(Optional.of(mockUser));
        when(passwordEncoderPort.matches("secret123", "encoded_pass")).thenReturn(true);
        when(tokenProviderPort.generateToken(mockUser)).thenReturn("sample_token_xyz");

        LoginResult result = loginService.login(command);

        assertNotNull(result);
        assertEquals("sample_token_xyz", result.getToken());
        assertEquals("test@example.com", result.getUser().getEmail());
        assertEquals(UserRole.CUSTOMER, result.getUser().getRole());
    }
}
