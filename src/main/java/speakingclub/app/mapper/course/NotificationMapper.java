package speakingclub.app.mapper.course;

import org.mapstruct.Mapper;
import speakingclub.app.config.MapperConfig;
import speakingclub.app.dto.course.NotificationDto;
import speakingclub.app.dto.user.ProfileDto;
import speakingclub.app.model.Notification;
import speakingclub.app.model.Profile;

@Mapper(config = MapperConfig.class)
public interface NotificationMapper {
    NotificationDto toDto(Notification notification);

    Notification toModel(NotificationDto notificationDto);
}
