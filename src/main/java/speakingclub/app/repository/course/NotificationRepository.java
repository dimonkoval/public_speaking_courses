package speakingclub.app.repository.course;

import org.springframework.data.jpa.repository.JpaRepository;
import speakingclub.app.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
