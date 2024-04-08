package speakingclub.app.service;

import java.util.Set;
import speakingclub.app.dto.course.SkillDto;
import speakingclub.app.model.Course;

public interface SkillService {
    void saveSkills(Set<SkillDto> skillDtos, Course savedCourse);
}
