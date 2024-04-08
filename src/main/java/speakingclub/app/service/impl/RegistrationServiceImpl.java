package speakingclub.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import speakingclub.app.dto.user.UserRegistrationRequestDto;
import speakingclub.app.dto.user.UserResponseDto;
import speakingclub.app.exception.RegistrationException;
import speakingclub.app.mapper.user.UserMapper;
import speakingclub.app.model.Role;
import speakingclub.app.model.User;
import speakingclub.app.model.enums.RoleName;
import speakingclub.app.repository.user.RoleRepository;
import speakingclub.app.repository.user.UserRepository;
import speakingclub.app.service.RegistrationService;

@RequiredArgsConstructor
@Service
public class RegistrationServiceImpl implements RegistrationService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public UserResponseDto registerUser(UserRegistrationRequestDto requestDto) {
        if (userRepository.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new RegistrationException("Can't register user with email "
                    + requestDto.getEmail());
        }
        Role userRole = roleRepository.findRoleByRoleName(RoleName.USER);
        User user = userMapper.toModel(requestDto);
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        user.getRoles().add(userRole);
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }
}
