package speakingclub.app.mapper.course;

import java.util.HashSet;
import java.util.Set;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import speakingclub.app.config.MapperConfig;
import speakingclub.app.dto.course.ThemaDto;
import speakingclub.app.model.Thema;

@Mapper(config = MapperConfig.class, uses = LessonMapper.class)
public interface ThemaMapper {
    @Mapping(target = "lessons", ignore = true)
    Thema toModel(ThemaDto themaDto);

    @Mapping(target = "lessons", source = "lessons", qualifiedByName = "lessonDtoByModel")
    ThemaDto toDto(Thema thema);

    @Named("themaDtoByModel")
    default Set<ThemaDto> themaDtoByModel(Set<Thema> themas) {
        Set<ThemaDto> themaDtos = new HashSet<>();
        for (Thema thema : themas) {
            themaDtos.add(toDto(thema));
        }
        return themaDtos;
    }
}
