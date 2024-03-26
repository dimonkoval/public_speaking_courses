package speakingclub.app.service;

import speakingclub.app.dto.user.UserRegistrationRequestDto;
import speakingclub.app.dto.user.UserResponseDto;

public interface RegistrationService {
    UserResponseDto registerUser(UserRegistrationRequestDto requestDto);
}
