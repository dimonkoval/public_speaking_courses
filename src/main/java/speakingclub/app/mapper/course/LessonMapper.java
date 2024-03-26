package speakingclub.app.mapper.course;

import java.util.HashSet;
import java.util.Set;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import speakingclub.app.config.MapperConfig;
import speakingclub.app.dto.course.LessonDto;
import speakingclub.app.model.Lesson;

@Mapper(config = MapperConfig.class, uses = HomeworkMapper.class)
public interface LessonMapper {
    @Mapping(target = "homeworks", ignore = true)
    Lesson toModel(LessonDto lessonDto);

    @Mapping(target = "homeworks", source = "homeworks", qualifiedByName = "homeworkDtoByModel")
    LessonDto toDto(Lesson lesson);

    @Named("lessonDtoByModel")
    default Set<LessonDto> lessonDtoByModel(Set<Lesson> lessons) {
        Set<LessonDto> lessonDtos = new HashSet<>();
        for (Lesson lesson : lessons) {
            lessonDtos.add(toDto(lesson));
        }
        return lessonDtos;
    }
}
