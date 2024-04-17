package speakingclub.app.repository.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import speakingclub.app.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course,Long> {
    @Query("SELECT DISTINCT c FROM Course c JOIN FETCH c.skills JOIN FETCH c.modules m JOIN FETCH m.themas t "
            + "JOIN FETCH t.lessons l JOIN FETCH l.homeworks")
    List<Course> getAllCourses();

    Optional<Course> findById(Long Id);
}
