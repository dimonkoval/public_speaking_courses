package speakingclub.app.service;

import speakingclub.app.dto.course.NotificationDto;
import speakingclub.app.model.Profile;

import java.util.Set;

public interface NotificationService {
    Set<NotificationDto> saveNotifications(Set<NotificationDto> notificationDtos, Profile savedProfile);
}
