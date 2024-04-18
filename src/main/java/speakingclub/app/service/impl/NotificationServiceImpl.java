package speakingclub.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import speakingclub.app.dto.course.NotificationDto;
import speakingclub.app.mapper.course.NotificationMapper;
import speakingclub.app.model.Notification;
import speakingclub.app.model.Profile;
import speakingclub.app.repository.course.NotificationRepository;
import speakingclub.app.repository.user.ProfileRepository;
import speakingclub.app.service.NotificationService;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationMapper notificationMapper;
    private final NotificationRepository notificationRepository;
//    private final ProfileRepository profileRepository;
    @Override
    public Set<NotificationDto> saveNotifications(Set<NotificationDto> notificationDtos, Profile savedProfile) {
        Set<NotificationDto> savedNotificationDtos = new HashSet<>();
        for (NotificationDto notificationDto : notificationDtos) {
            Notification notification = notificationMapper.toModel(notificationDto);
            notification.setProfile(savedProfile);
            Notification savedNotification = notificationRepository.save(notification);
            NotificationDto savedNotificationDto = notificationMapper.toDto(savedNotification);
            savedNotificationDtos.add(savedNotificationDto);
        }
       return savedNotificationDtos;
    }
}
