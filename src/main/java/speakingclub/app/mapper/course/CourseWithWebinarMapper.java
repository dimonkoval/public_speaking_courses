package speakingclub.app.mapper.course;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import speakingclub.app.config.MapperConfig;
import speakingclub.app.dto.course.CourseWithWebinarDto;
import speakingclub.app.model.Course;

@Mapper(config = MapperConfig.class, uses = {ModuleWithWebinarMapper.class, SkillMapper.class})
public interface CourseWithWebinarMapper {
    @Mapping(target = "skills", ignore = true)
    @Mapping(target = "modules", ignore = true)
    @Mapping(target = "startDate", source = "startDate")
    @Mapping(target = "endDate", source = "endDate")
    Course toModel(CourseWithWebinarDto courseWithWebinarDto);

    @Mapping(target = "skills", source = "skills", qualifiedByName = "skillDtoByModel")
    @Mapping(target = "modules", source = "modules", qualifiedByName
            = "moduleWithWebinarDtoByModel")
    @Mapping(target = "startDate", source = "startDate")
    @Mapping(target = "endDate", source = "endDate")
    CourseWithWebinarDto toDto(Course course);
}
