package speakingclub.app.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import speakingclub.app.dto.user.ProfileDto;
import speakingclub.app.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    @Query("SELECT p FROM Profile p JOIN p.user u WHERE u.id = :userId")
    ProfileDto getProfileByUserID(Long userId);

}
