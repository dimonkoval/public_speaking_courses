package speakingclub.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import speakingclub.app.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
