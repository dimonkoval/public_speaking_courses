package speakingclub.app.repository.course;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import speakingclub.app.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    Optional<Skill> findByName(String name);
}
