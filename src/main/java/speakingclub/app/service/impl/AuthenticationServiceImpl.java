package speakingclub.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import speakingclub.app.dto.UserLoginRequestDto;
import speakingclub.app.dto.UserLoginResponseDto;
import speakingclub.app.exception.AuthenticationException;
import speakingclub.app.security.JwtUtil;
import speakingclub.app.service.AuthenticationService;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @Override
    public UserLoginResponseDto authenticate(UserLoginRequestDto request) {
        try {
            final Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.email(), request.password()));
            String token = jwtUtil.generateToken(request.email());
            return new UserLoginResponseDto(token);
        } catch (Exception e) {
            throw new AuthenticationException("Incorrect username or password");
        }
    }
}
