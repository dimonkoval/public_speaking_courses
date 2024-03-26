package speakingclub.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import speakingclub.app.dto.user.UserRegistrationRequestDto;
import speakingclub.app.dto.user.UserResponseDto;
import speakingclub.app.exception.RegistrationException;
import speakingclub.app.mapper.user.UserMapper;
import speakingclub.app.model.User;
import speakingclub.app.repository.user.UserRepository;
import speakingclub.app.service.RegistrationService;

@RequiredArgsConstructor
@Service
public class RegistrationServiceImpl implements RegistrationService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto registerUser(UserRegistrationRequestDto requestDto) {
        if (userRepository.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new RegistrationException("Can't register user with email "
                    + requestDto.getEmail());
        }
        User user = userMapper.toModel(requestDto);
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }
}
