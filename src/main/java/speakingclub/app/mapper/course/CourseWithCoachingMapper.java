package speakingclub.app.mapper.course;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import speakingclub.app.config.MapperConfig;
import speakingclub.app.dto.course.CourseWithCoachingDto;
import speakingclub.app.model.Course;

@Mapper(config = MapperConfig.class, uses = SkillMapper.class)
public interface CourseWithCoachingMapper {
    @Mapping(target = "skills", ignore = true)
    Course toModel(CourseWithCoachingDto courseWithCoachingDto);

    @Mapping(target = "skills", source = "skills", qualifiedByName = "skillDtoByModel")
    CourseWithCoachingDto toDto(Course course);
}
