package speakingclub.app.mapper.course;

import org.mapstruct.Mapper;
import speakingclub.app.config.MapperConfig;
import speakingclub.app.dto.course.NotificationDto;
import speakingclub.app.model.Notification;

@Mapper(config = MapperConfig.class)
public interface NotificationMapper {
    NotificationDto toDto(Notification notification);

    Notification toModel(NotificationDto notificationDto);
}
