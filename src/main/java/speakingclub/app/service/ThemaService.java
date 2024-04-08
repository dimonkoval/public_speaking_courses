package speakingclub.app.service;

import java.util.Set;
import speakingclub.app.dto.course.ThemaDto;
import speakingclub.app.model.Module;

public interface ThemaService {
    Set<ThemaDto> saveThemas(Set<ThemaDto> themaDtos, Module savedModule);
}
