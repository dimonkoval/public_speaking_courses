package speakingclub.app.mapper.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import speakingclub.app.config.MapperConfig;
import speakingclub.app.dto.user.ProfileDto;
import speakingclub.app.mapper.course.NotificationMapper;
import speakingclub.app.model.Profile;

@Mapper(config = MapperConfig.class, uses = NotificationMapper.class)
public interface ProfileMapper {
    @Mapping(target = "notifications", ignore = true)
    Profile toModel(ProfileDto profileDto);

    @Mapping(target = "notifications", source = "notifications", qualifiedByName = "notificationDtoByModel")
    ProfileDto toDto(Profile profile);
}
