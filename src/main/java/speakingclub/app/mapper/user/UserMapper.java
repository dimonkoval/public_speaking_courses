package speakingclub.app.mapper.user;

import org.mapstruct.Mapper;
import speakingclub.app.config.MapperConfig;
import speakingclub.app.dto.user.UserRegistrationRequestDto;
import speakingclub.app.dto.user.UserResponseDto;
import speakingclub.app.model.User;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserResponseDto toDto(User user);

    User toModel(UserRegistrationRequestDto requestDto);
}
