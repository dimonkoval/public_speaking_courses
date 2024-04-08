package speakingclub.app.service;

import java.util.Set;
import speakingclub.app.dto.course.ModuleDto;
import speakingclub.app.dto.course.ModuleWithWebinarDto;
import speakingclub.app.model.Course;

public interface ModuleService {
    Set<ModuleDto> saveModules(Set<ModuleDto> moduleDtos, Course savedCourse);

    Set<ModuleWithWebinarDto> saveModulesWithWebinar(Set<ModuleWithWebinarDto> moduleDtos,
                                                     Course savedCourse);

}
