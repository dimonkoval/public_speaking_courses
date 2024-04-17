package speakingclub.app.repository.user;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import speakingclub.app.model.Course;
import speakingclub.app.model.Homework;
import speakingclub.app.model.Skill;
import speakingclub.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    @Query("SELECT c FROM User u JOIN u.courses c JOIN FETCH c.skills s JOIN FETCH c.modules m JOIN FETCH m.themas t "
            + "JOIN FETCH t.lessons l JOIN FETCH l.homeworks WHERE u.id = :userId")
    List<Course> getCoursesByStudentId(@Param("userId") Long userId);

    @Query("SELECT c FROM User u JOIN u.courses c JOIN FETCH c.skills s JOIN FETCH c.modules m JOIN FETCH m.themas t "
            + "JOIN FETCH t.lessons l JOIN FETCH l.homeworks WHERE u.id = :userId AND c.id = :courseId")
    Optional<Course> getCourseByIdAndUserId(@Param("userId")Long userId, @Param("courseId") Long courseId);

    @Query("SELECT s FROM User u JOIN u.courses c JOIN  c.skills s WHERE u.id = :userId")
    List<Skill> getSkillsByUserId(@Param("userId") Long userId);

    @Query("SELECT h FROM User u JOIN u.courses c JOIN c.skills s JOIN c.modules m JOIN m.themas t "
            + "JOIN t.lessons l JOIN l.homeworks h WHERE u.id = :userId")
    List<Homework> getHomeworksByUserId(@Param("userId") Long userId);

    @Query("SELECT u FROM User u WHERE u.id = :userId")
    Optional<User> getUserById(@Param("userId") Long userId);

    @Query("SELECT DISTINCT u FROM User u JOIN FETCH u.courses c JOIN  FETCH c.skills s JOIN  FETCH c.modules m JOIN FETCH m.themas t "
            + "JOIN FETCH t.lessons l JOIN FETCH l.homeworks WHERE u.id = :userId")
    Optional<User> getUserByIdAllElements(@Param("userId") Long userId);
}
