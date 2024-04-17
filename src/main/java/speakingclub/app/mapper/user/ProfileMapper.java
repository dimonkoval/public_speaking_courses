package speakingclub.app.mapper.user;

import org.mapstruct.Mapper;
import speakingclub.app.config.MapperConfig;
import speakingclub.app.dto.user.ProfileDto;
import speakingclub.app.dto.user.ProfileRequestDto;
import speakingclub.app.model.Profile;

@Mapper(config = MapperConfig.class)
public interface ProfileMapper {
    ProfileDto toDto(Profile profile);

    Profile toModel(ProfileDto profileDto);
}
