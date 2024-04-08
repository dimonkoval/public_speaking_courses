package speakingclub.app.service.impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import speakingclub.app.dto.course.SkillDto;
import speakingclub.app.mapper.course.SkillMapper;
import speakingclub.app.model.Course;
import speakingclub.app.model.Skill;
import speakingclub.app.repository.course.CourseRepository;
import speakingclub.app.repository.course.SkillRepository;
import speakingclub.app.service.SkillService;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {
    private final SkillMapper skillMapper;
    private final SkillRepository skillRepository;
    private final CourseRepository courseRepository;

    @Override
    public void saveSkills(Set<SkillDto> skillDtos, Course savedCourse) {
        Set<Skill> savedSkills = new HashSet<>();

        for (SkillDto skillDto : skillDtos) {
            Optional<Skill> existingSkill = skillRepository.findByName(skillDto.getName());
            if (existingSkill.isPresent()) {
                savedSkills.add(existingSkill.get());
            } else {
                Skill newSkill = skillMapper.toModel(skillDto);
                savedSkills.add(newSkill);
            }
        }
        savedCourse.setSkills(savedSkills);
        courseRepository.save(savedCourse);
    }
}
