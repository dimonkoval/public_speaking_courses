package speakingclub.app.service.impl;

import jakarta.annotation.PostConstruct;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import speakingclub.app.dto.UserRegistrationRequestDto;
import speakingclub.app.dto.UserResponseDto;
import speakingclub.app.exception.RegistrationException;
import speakingclub.app.mapper.UserMapper;
import speakingclub.app.model.User;
import speakingclub.app.model.enums.RoleName;
import speakingclub.app.repository.UserRepository;
import speakingclub.app.service.RegistrationService;
import speakingclub.app.service.RoleService;

@RequiredArgsConstructor
@Service
public class RegistrationServiceImpl implements RegistrationService {
    private static final String ADMIN_EMAIL = "admin@gmail.com";
    private static final String ADMIN_PASSWORD = "qwerty_12345";
    private static final String ADMIN_FIRSTNAME = "Anastasia";
    private static final String ADMIN_LASTNAME = "Shkiria";
    private final UserRepository userRepository;
    private final RoleService roleService;
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

    @PostConstruct
    public void registerAdmin() {
        if (userRepository.findByEmail(ADMIN_EMAIL).isPresent()) {
            return;
        }
        User user = new User();
        user.setEmail(ADMIN_EMAIL);
        user.setPassword(passwordEncoder.encode(ADMIN_PASSWORD));
        user.setFirstName(ADMIN_FIRSTNAME);
        user.setLastName(ADMIN_LASTNAME);
        user.setRoles(Set.of(roleService.findRoleByRoleName(RoleName.ADMIN)));
        userRepository.save(user);
    }
}
