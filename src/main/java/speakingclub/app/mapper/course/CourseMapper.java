package speakingclub.app.mapper.course;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import speakingclub.app.config.MapperConfig;
import speakingclub.app.dto.course.CourseDto;
import speakingclub.app.model.Course;

@Mapper(config = MapperConfig.class, uses = ModuleMapper.class)
public interface CourseMapper {
    @Mapping(target = "modules", ignore = true)
    Course toModel(CourseDto dto);

    @Mapping(target = "modules", source = "modules", qualifiedByName = "moduleDtoByModel")
    CourseDto toDto(Course course);
}
