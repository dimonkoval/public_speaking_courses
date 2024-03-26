package speakingclub.app.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import speakingclub.app.model.Role;
import speakingclub.app.model.enums.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByRoleName(RoleName roleName);
}
