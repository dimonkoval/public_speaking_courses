package speakingclub.app.repository.course;

import org.springframework.data.jpa.repository.JpaRepository;
import speakingclub.app.model.Course;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
