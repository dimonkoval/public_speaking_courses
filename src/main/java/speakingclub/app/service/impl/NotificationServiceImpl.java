package speakingclub.app.service.impl;

import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import speakingclub.app.dto.course.NotificationDto;
import speakingclub.app.mapper.course.NotificationMapper;
import speakingclub.app.model.Notification;
import speakingclub.app.model.Profile;
import speakingclub.app.repository.course.NotificationRepository;
import speakingclub.app.service.NotificationService;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationMapper notificationMapper;
    private final NotificationRepository notificationRepository;

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

    @Override
    public Page<Notification> getAllNotificationsWithPaginationAndSorting(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return notificationRepository.findAll(pageable);
    }
}
