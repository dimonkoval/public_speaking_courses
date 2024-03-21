package speakingclub.app.service;

import speakingclub.app.dto.UserRegistrationRequestDto;
import speakingclub.app.dto.UserResponseDto;

public interface RegistrationService {
    UserResponseDto registerUser(UserRegistrationRequestDto requestDto);
}
