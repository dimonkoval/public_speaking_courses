package speakingclub.app.repository.course;

import org.springframework.data.jpa.repository.JpaRepository;
import speakingclub.app.model.Homework;

public interface HomeworkRepository extends JpaRepository<Homework, Long> {
}
