package speakingclub.app.service.impl;

import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import speakingclub.app.dto.course.ModuleDto;
import speakingclub.app.dto.course.ModuleWithWebinarDto;
import speakingclub.app.dto.course.ThemaDto;
import speakingclub.app.dto.course.WebinarDto;
import speakingclub.app.mapper.course.ModuleMapper;
import speakingclub.app.mapper.course.ModuleWithWebinarMapper;
import speakingclub.app.mapper.course.WebinarMapper;
import speakingclub.app.model.Course;
import speakingclub.app.model.Module;
import speakingclub.app.repository.course.ModuleRepository;
import speakingclub.app.service.ModuleService;
import speakingclub.app.service.ThemaService;
import speakingclub.app.service.WebinarService;

@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {
    private final ModuleMapper moduleMapper;
    private final WebinarMapper webinarMapper;
    private final ModuleWithWebinarMapper moduleWithWebinarMapper;
    private final ModuleRepository moduleRepository;
    private final WebinarService webinarService;
    private final ThemaService themaService;

    @Override
    public Set<ModuleDto> saveModules(Set<ModuleDto> moduleDtos, Course savedCourse) {
        Set<ModuleDto> savedModules = new HashSet<>();
        for (ModuleDto moduleDto : moduleDtos) {
            Module module = moduleMapper.toModel(moduleDto);
            module.setCourse(savedCourse);
            Module savedModule = moduleRepository.save(module);

            Set<ThemaDto> themas = moduleDto.getThemas();
            Set<ThemaDto> savedThemas = themaService.saveThemas(themas, savedModule);

            ModuleDto savedModuleDto = moduleMapper.toDto(savedModule);
            savedModuleDto.setThemas(savedThemas);
            savedModules.add(savedModuleDto);
        }
        return savedModules;
    }

    @Override
    public Set<ModuleWithWebinarDto> saveModulesWithWebinar(Set<ModuleWithWebinarDto> moduleDtos,
                                                            Course savedCourse) {
        Set<ModuleWithWebinarDto> savedModules = new HashSet<>();
        for (ModuleWithWebinarDto moduleDto : moduleDtos) {
            Module module = moduleWithWebinarMapper.toModel(moduleDto);
            module.setCourse(savedCourse);
            Module savedModule = moduleRepository.save(module);

            WebinarDto webinarDto = webinarService
                    .saveWebinar(moduleDto.getWebinar(), savedModule);

            Set<ThemaDto> themas = moduleDto.getThemas();
            Set<ThemaDto> savedThemas = themaService.saveThemas(themas, savedModule);

            ModuleWithWebinarDto savedModuleDto
                    = moduleWithWebinarMapper.toDto(savedModule);
            savedModuleDto.setWebinar(webinarDto);
            savedModuleDto.setThemas(savedThemas);
            savedModules.add(savedModuleDto);
        }
        return savedModules;
    }
}
