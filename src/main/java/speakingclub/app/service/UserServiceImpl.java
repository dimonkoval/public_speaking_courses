package speakingclub.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import speakingclub.app.dto.UserRegistrationRequestDto;
import speakingclub.app.dto.UserResponseDto;
import speakingclub.app.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserResponseDto registerUser(UserRegistrationRequestDto requestDto) {
        return null;
    }
}
