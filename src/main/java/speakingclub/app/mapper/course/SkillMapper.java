package speakingclub.app.mapper.course;

import java.util.HashSet;
import java.util.Set;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import speakingclub.app.config.MapperConfig;
import speakingclub.app.dto.course.SkillDto;
import speakingclub.app.model.Skill;

@Mapper(config = MapperConfig.class)
public interface SkillMapper {
    Skill toModel(SkillDto skillDto);

    SkillDto toDto(Skill skill);

    @Named("skillDtoByModel")
    default Set<SkillDto> skillDtoByModel(Set<Skill> skills) {
        Set<SkillDto> skillDtos = new HashSet<>();
        for (Skill skill : skills) {
            skillDtos.add(toDto(skill));
        }
        return skillDtos;
    }
}
