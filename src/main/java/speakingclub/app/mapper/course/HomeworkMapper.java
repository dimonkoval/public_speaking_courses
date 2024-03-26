package speakingclub.app.mapper.course;

import java.util.HashSet;
import java.util.Set;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import speakingclub.app.config.MapperConfig;
import speakingclub.app.dto.course.HomeworkDto;
import speakingclub.app.model.Homework;

@Mapper(config = MapperConfig.class)
public interface HomeworkMapper {
    Homework toModel(HomeworkDto homeworkDto);

    HomeworkDto toDto(Homework homework);

    @Named("homeworkDtoByModel")
    default Set<HomeworkDto> homeworkDtoByModel(Set<Homework> homeworks) {
        Set<HomeworkDto> homeworkDtos = new HashSet<>();
        for (Homework homework : homeworks) {
            homeworkDtos.add(toDto(homework));
        }
        return homeworkDtos;
    }
}
