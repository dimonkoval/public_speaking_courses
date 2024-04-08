package speakingclub.app.service.impl;

import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import speakingclub.app.dto.course.CourseDto;
import speakingclub.app.dto.course.CourseWithCoachingDto;
import speakingclub.app.dto.course.CourseWithWebinarDto;
import speakingclub.app.dto.course.ModuleDto;
import speakingclub.app.dto.course.ModuleWithWebinarDto;
import speakingclub.app.mapper.course.CourseMapper;
import speakingclub.app.mapper.course.CourseWithCoachingMapper;
import speakingclub.app.mapper.course.CourseWithWebinarMapper;
import speakingclub.app.model.Course;
import speakingclub.app.repository.course.CourseRepository;
import speakingclub.app.service.CourseService;
import speakingclub.app.service.ModuleService;
import speakingclub.app.service.SkillService;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseMapper courseMapper;
    private final CourseRepository courseRepository;
    private final SkillService skillService;
    private final ModuleService moduleService;
    private final CourseWithWebinarMapper courseWithWebinarMapper;
    private final CourseWithCoachingMapper courseWithCoachingMapper;

    @Override
    public CourseDto saveCourse(CourseDto courseDto) {
        Course course = courseMapper.toModel(courseDto);
        Course savedCourse = courseRepository.save(course);

        skillService.saveSkills(courseDto.getSkills(), savedCourse);

        Set<ModuleDto> modules = courseDto.getModules();
        Set<ModuleDto> savedModules = moduleService.saveModules(modules, savedCourse);

        CourseDto savedCourseDto = courseMapper.toDto(savedCourse);
        savedCourseDto.setModules(savedModules);
        return savedCourseDto;
    }

    @Override
    public CourseWithWebinarDto saveCourseWithWebinar(CourseWithWebinarDto courseWithWebinarDto) {
        Course courseWithWebinar = courseWithWebinarMapper.toModel(courseWithWebinarDto);
        Course savedCourse = courseRepository.save(courseWithWebinar);

        skillService.saveSkills(courseWithWebinarDto.getSkills(), savedCourse);

        Set<ModuleWithWebinarDto> modules = courseWithWebinarDto.getModules();
        Set<ModuleWithWebinarDto> savedModules
                = moduleService.saveModulesWithWebinar(modules, savedCourse);

        CourseWithWebinarDto savedCourseDto = courseWithWebinarMapper.toDto(savedCourse);
        savedCourseDto.setModules(savedModules);
        return savedCourseDto;
    }

    @Override
    public CourseWithCoachingDto saveCourseWithCoaching(
            CourseWithCoachingDto courseWithCoachingDto) {
        Course course = courseWithCoachingMapper.toModel(courseWithCoachingDto);
        Course savedCourse = courseRepository.save(course);
        skillService.saveSkills(courseWithCoachingDto.getSkills(), savedCourse);
        return courseWithCoachingMapper.toDto(savedCourse);
    }
}
