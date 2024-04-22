package speakingclub.app.service;

import java.util.Set;
import org.springframework.data.domain.Page;
import speakingclub.app.dto.course.NotificationDto;
import speakingclub.app.model.Notification;
import speakingclub.app.model.Profile;

public interface NotificationService {
    Set<NotificationDto> saveNotifications(Set<NotificationDto> notificationDtos, Profile savedProfile);

    Page<Notification> getAllNotificationsWithPaginationAndSorting(int pageNo, int pageSize, String sortBy);
}
