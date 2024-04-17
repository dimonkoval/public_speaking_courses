package speakingclub.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import speakingclub.app.dto.course.NotificationDto;
import speakingclub.app.mapper.course.NotificationMapper;
import speakingclub.app.mapper.user.ProfileMapper;
import speakingclub.app.model.Notification;
import speakingclub.app.model.Profile;
import speakingclub.app.repository.course.NotificationRepository;
import speakingclub.app.service.NotificationService;
import speakingclub.app.service.ProfileService;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationMapper notificationMapper;
    private final NotificationRepository notificationRepository;
    @Override
    public Set<NotificationDto> saveNotifications(Set<NotificationDto> notificationDtos, Profile savedProfile) {
//        Set<ModuleDto> savedModules = new HashSet<>();
//        for (ModuleDto moduleDto : moduleDtos) {
//            Module module = moduleMapper.toModel(moduleDto);
//            module.setCourse(savedCourse);
//            Module savedModule = moduleRepository.save(module);
//
//            Set<ThemaDto> themas = moduleDto.getThemas();
//            Set<ThemaDto> savedThemas = themaService.saveThemas(themas, savedModule);
//
//            ModuleDto savedModuleDto = moduleMapper.toDto(savedModule);
//            savedModuleDto.setThemas(savedThemas);
//            savedModules.add(savedModuleDto);
//        }
//        return savedModules;

        Set<NotificationDto> savedNotifications = new HashSet<>();
        for ( NotificationDto notificationDto : notificationDtos) {
            Notification notification = notificationMapper.toModel(notificationDto);
            notification.setProfile(savedProfile);
            Notification savedNotification = notificationRepository.save(notification);
            NotificationDto savedNotificationDto = notificationMapper.toDto(savedNotification);
            savedNotifications.add(savedNotificationDto);
        }
        return savedNotifications;
    }
}
