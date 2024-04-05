package speakingclub.app.repository.course;

import org.springframework.data.jpa.repository.JpaRepository;
import speakingclub.app.model.Webinar;

public interface WebinarRepository extends JpaRepository<Webinar, Long> {
}
