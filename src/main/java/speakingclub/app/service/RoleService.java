package speakingclub.app.service;

import org.springframework.data.jpa.repository.JpaRepository;
import speakingclub.app.model.Role;
import speakingclub.app.model.RoleName;

public interface RoleService extends JpaRepository<Role, Long> {
    Role findRoleByRoleName(RoleName roleName);
}
