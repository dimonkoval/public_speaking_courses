package speakingclub.app.mapper.course;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import speakingclub.app.config.MapperConfig;
import speakingclub.app.dto.course.NotificationDto;
import speakingclub.app.model.Notification;

import java.util.HashSet;
import java.util.Set;

@Mapper(config = MapperConfig.class)
public interface NotificationMapper {
    NotificationDto toDto(Notification notification);

    Notification toModel(NotificationDto notificationDto);

    @Named("notificationDtoByModel")
    default Set<NotificationDto> notificationDtoByModel(Set<Notification> notifications) {
        Set<NotificationDto> notificationDtos = new HashSet<>();
        for (Notification notification : notifications) {
            notificationDtos.add(toDto(notification));
        }
        return notificationDtos;
    }
}
