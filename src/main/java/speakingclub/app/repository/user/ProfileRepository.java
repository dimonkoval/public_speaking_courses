package speakingclub.app.repository.user;

import java.util.Optional;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import speakingclub.app.model.Course;
import speakingclub.app.model.Notification;
import speakingclub.app.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    @Query("SELECT p FROM Profile p JOIN p.user u LEFT JOIN FETCH p.notifications n WHERE u.id = :userId")
    Optional<Profile> getProfileByUserID(Long userId);

    @Query("SELECT DISTINCT n FROM Profile p JOIN p.user u LEFT JOIN p.notifications n WHERE p.id = :profileId")
    Set<Notification> getNotificationsByProfileId(Long profileId);

    @Query("SELECT DISTINCT c FROM Profile p JOIN p.user u LEFT JOIN u.courses c LEFT JOIN p.notifications n "
            + "JOIN FETCH c.skills JOIN FETCH c.modules m JOIN FETCH m.themas t "
            + "JOIN FETCH t.lessons l JOIN FETCH l.homeworks WHERE p.id = :profileId")
    Set<Course> getCoursesByProfileId(Long profileId);
}
