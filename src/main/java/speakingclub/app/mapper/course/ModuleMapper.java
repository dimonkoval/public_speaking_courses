package speakingclub.app.mapper.course;

import java.util.HashSet;
import java.util.Set;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import speakingclub.app.config.MapperConfig;
import speakingclub.app.dto.course.ModuleDto;
import speakingclub.app.model.Module;

@Mapper(config = MapperConfig.class, uses = ThemaMapper.class)
public interface ModuleMapper {
    @Mapping(target = "themas", ignore = true)
    @Mapping(target = "webinar", ignore = true)
    Module toModel(ModuleDto dto);

    @Mapping(target = "themas", source = "themas", qualifiedByName = "themaDtoByModel")
    @Mapping(target = "webinar", source = "webinar")
    ModuleDto toDto(Module module);

    @Named("moduleDtoByModel")
    default Set<ModuleDto> moduleDtoByModel(Set<Module> modules) {
        Set<ModuleDto> moduleDtos = new HashSet<>();
        for (Module module : modules) {
            moduleDtos.add(toDto(module));
        }
        return moduleDtos;
    }

}
