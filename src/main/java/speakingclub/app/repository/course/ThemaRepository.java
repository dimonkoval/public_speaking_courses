package speakingclub.app.repository.course;

import org.springframework.data.jpa.repository.JpaRepository;
import speakingclub.app.model.Thema;

public interface ThemaRepository extends JpaRepository<Thema, Long> {
}
