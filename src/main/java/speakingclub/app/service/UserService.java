package speakingclub.app.service;

import speakingclub.app.dto.UserRegistrationRequestDto;
import speakingclub.app.dto.UserResponseDto;

public interface UserService {
    UserResponseDto registerUser(UserRegistrationRequestDto requestDto);
}
