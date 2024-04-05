package speakingclub.app.mapper.course;

import org.mapstruct.Mapper;
import speakingclub.app.config.MapperConfig;
import speakingclub.app.dto.course.WebinarDto;
import speakingclub.app.model.Webinar;

@Mapper(config = MapperConfig.class)
public interface WebinarMapper {
    Webinar toModel(WebinarDto requestDto);

    WebinarDto toDto(Webinar webinar);
}
