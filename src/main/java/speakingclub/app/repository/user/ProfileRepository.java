package speakingclub.app.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import speakingclub.app.model.Profile;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    @Query("SELECT p FROM Profile p JOIN p.user u LEFT JOIN p.notifications n WHERE u.id = :userId")
    Optional<Profile> getProfileByUserID(Long userId);

}
