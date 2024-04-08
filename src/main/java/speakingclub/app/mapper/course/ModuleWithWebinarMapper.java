package speakingclub.app.mapper.course;

import java.util.HashSet;
import java.util.Set;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import speakingclub.app.config.MapperConfig;
import speakingclub.app.dto.course.ModuleWithWebinarDto;
import speakingclub.app.model.Module;

@Mapper(config = MapperConfig.class, uses = ThemaMapper.class)
public interface ModuleWithWebinarMapper {
    @Mapping(target = "themas", ignore = true)
    @Mapping(target = "webinar", ignore = true)
    Module toModel(ModuleWithWebinarDto moduleWithWebinarDto);

    @Mapping(target = "themas", source = "themas", qualifiedByName = "themaDtoByModel")
    @Mapping(target = "webinar", source = "webinar")
    ModuleWithWebinarDto toDto(Module module);

    @Named("moduleWithWebinarDtoByModel")
    default Set<ModuleWithWebinarDto> moduleWithWebinarDtoByModel(Set<Module> modules) {
        Set<ModuleWithWebinarDto> moduleDtos = new HashSet<>();
        for (Module module : modules) {
            moduleDtos.add(toDto(module));
        }
        return moduleDtos;
    }
}
