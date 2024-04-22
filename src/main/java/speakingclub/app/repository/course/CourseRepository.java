package speakingclub.app.repository.course;

import java.util.Optional;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import speakingclub.app.model.Course;
import speakingclub.app.model.enums.CourseDirection;
import speakingclub.app.model.enums.CourseType;

public interface CourseRepository extends JpaRepository<Course,Long> {

    Optional<Course> findById(Long id);

    @Query("SELECT DISTINCT c FROM Course c JOIN FETCH c.skills JOIN FETCH c.modules m JOIN FETCH m.themas t "
            + "JOIN FETCH t.lessons l JOIN FETCH l.homeworks WHERE (:type IS NULL OR c.courseType = :type) "
            + "AND (:direction IS NULL OR c.courseDirection = :direction)")
    Set<Course> getCourses(CourseType type, CourseDirection direction);
}
