package speakingclub.app.service;

import speakingclub.app.dto.course.NotificationDto;
import speakingclub.app.model.Profile;

import java.util.Set;

public interface NotificationService {
    void saveNotifications(Set<NotificationDto> notificationDtos, Profile savedProfile);
}
