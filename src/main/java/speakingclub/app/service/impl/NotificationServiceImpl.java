package speakingclub.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import speakingclub.app.dto.course.NotificationDto;
import speakingclub.app.dto.course.SkillDto;
import speakingclub.app.mapper.course.NotificationMapper;
import speakingclub.app.model.Notification;
import speakingclub.app.model.Profile;
import speakingclub.app.model.Skill;
import speakingclub.app.repository.course.NotificationRepository;
import speakingclub.app.repository.user.ProfileRepository;
import speakingclub.app.service.NotificationService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationMapper notificationMapper;
    private final ProfileRepository profileRepository;
    @Override
    public void saveNotifications(Set<NotificationDto> notificationDtos, Profile savedProfile) {
        Set<Notification> savedNotifications = new HashSet<>();
        for (NotificationDto notificationDto : notificationDtos) {
            Notification notification = notificationMapper.toModel(notificationDto);
            savedNotifications.add(notification);
        }
        savedProfile.setNotifications(savedNotifications);
        profileRepository.save(savedProfile);
    }
}
