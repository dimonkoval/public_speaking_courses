package speakingclub.app.repository.course;

import org.springframework.data.jpa.repository.JpaRepository;
import speakingclub.app.model.Module;

public interface ModuleRepository extends JpaRepository<Module, Long> {
}
