package speakingclub.app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import speakingclub.app.dto.user.UserLoginRequestDto;
import speakingclub.app.dto.user.UserLoginResponseDto;
import speakingclub.app.dto.user.UserRegistrationRequestDto;
import speakingclub.app.dto.user.UserResponseDto;
import speakingclub.app.exception.AuthenticationException;
import speakingclub.app.exception.RegistrationException;
import speakingclub.app.service.AuthenticationService;
import speakingclub.app.service.RegistrationService;

@Tag(name = "User manager", description = "Endpoints for user authentication")
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final RegistrationService registrationService;
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Register a new user", description = "Register a new user")
    public UserResponseDto register(@RequestBody @Valid UserRegistrationRequestDto requestDto)
            throws RegistrationException {
        return registrationService.registerUser(requestDto);
    }

    @PostMapping("/login")
    @Operation(summary = "Login", description = "Login user or admin")
    public UserLoginResponseDto login(@RequestBody @Valid UserLoginRequestDto request)
            throws AuthenticationException {
        return authenticationService.authenticate(request);
    }
}
