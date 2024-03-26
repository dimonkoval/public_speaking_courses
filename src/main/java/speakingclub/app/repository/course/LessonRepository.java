package speakingclub.app.repository.course;

import org.springframework.data.jpa.repository.JpaRepository;
import speakingclub.app.model.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
