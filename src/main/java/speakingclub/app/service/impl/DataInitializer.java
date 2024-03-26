package speakingclub.app.service.impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import speakingclub.app.model.Role;
import speakingclub.app.model.User;
import speakingclub.app.model.enums.RoleName;
import speakingclub.app.repository.user.RoleRepository;
import speakingclub.app.repository.user.UserRepository;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private static final String ADMIN_EMAIL = "admin@gmail.com";
    private static final String ADMIN_PASSWORD = "qwerty_12345";
    private static final String ADMIN_FIRSTNAME = "Anastasia";
    private static final String ADMIN_LASTNAME = "Shkiria";
    private static final RoleName USER_ROLE = RoleName.USER;
    private static final RoleName ADMIN_ROLE = RoleName.ADMIN;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        initializeRoles();
        initializeUsers();
    }

    private void initializeRoles() {
        Role roleByRoleNameUser = roleRepository.findRoleByRoleName(USER_ROLE);
        Role roleByRoleNameAdmin = roleRepository.findRoleByRoleName(ADMIN_ROLE);

        Role userRole = new Role(USER_ROLE);
        Role adminRole = new Role(ADMIN_ROLE);

        if (roleByRoleNameUser == null) {
            roleRepository.save(userRole);
        }
        if (roleByRoleNameAdmin == null) {
            roleRepository.save(adminRole);
        }
    }

    private void initializeUsers() {
        Optional<User> adminByEmail = userRepository.findByEmail(ADMIN_EMAIL);
        if (adminByEmail.isPresent()) {
            return;
        }
        Role adminRole = roleRepository.findRoleByRoleName(RoleName.ADMIN);
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);

        User user = new User();
        user.setEmail(ADMIN_EMAIL);
        user.setPassword(passwordEncoder.encode(ADMIN_PASSWORD));
        user.setFirstName(ADMIN_FIRSTNAME);
        user.setLastName(ADMIN_LASTNAME);
        user.setRoles(adminRoles);
    }
}
