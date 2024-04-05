package speakingclub.app.service.impl;

import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import speakingclub.app.dto.course.CourseDto;
import speakingclub.app.dto.course.HomeworkDto;
import speakingclub.app.dto.course.LessonDto;
import speakingclub.app.dto.course.ModuleDto;
import speakingclub.app.dto.course.ThemaDto;
import speakingclub.app.mapper.course.CourseMapper;
import speakingclub.app.mapper.course.HomeworkMapper;
import speakingclub.app.mapper.course.LessonMapper;
import speakingclub.app.mapper.course.ModuleMapper;
import speakingclub.app.mapper.course.ThemaMapper;
import speakingclub.app.mapper.course.WebinarMapper;
import speakingclub.app.model.Course;
import speakingclub.app.model.Homework;
import speakingclub.app.model.Lesson;
import speakingclub.app.model.Module;
import speakingclub.app.model.Thema;
import speakingclub.app.model.Webinar;
import speakingclub.app.model.enums.CourseType;
import speakingclub.app.repository.course.CourseRepository;
import speakingclub.app.repository.course.HomeworkRepository;
import speakingclub.app.repository.course.LessonRepository;
import speakingclub.app.repository.course.ModuleRepository;
import speakingclub.app.repository.course.ThemaRepository;
import speakingclub.app.repository.course.WebinarRepository;
import speakingclub.app.service.CourseService;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseMapper courseMapper;
    private final ModuleMapper moduleMapper;
    private final CourseRepository courseRepository;
    private final ModuleRepository moduleRepository;
    private final ThemaMapper themaMapper;
    private final ThemaRepository themaRepository;
    private final LessonMapper lessonMapper;
    private final LessonRepository lessonRepository;
    private final HomeworkMapper homeworkMapper;
    private final HomeworkRepository homeworkRepository;
    private final WebinarMapper webinarMapper;
    private final WebinarRepository webinarRepository;

    @Override
    public CourseDto saveCourse(CourseDto courseDto) {
        Course course = courseMapper.toModel(courseDto);
        Course savedCourse = courseRepository.save(course);

        if (savedCourse.getCourseType() == CourseType.FLEXIBLE_WITH_WEBINARS) {
            savedCourse.setStartDate(courseDto.getStartDate());
            savedCourse.setEndDate(courseDto.getEndDate());
            courseRepository.save(savedCourse);
        }

        Set<ModuleDto> modules = courseDto.getModules();
        Set<ModuleDto> savedModules = saveModules(modules, savedCourse);

        CourseDto savedCourseDto = courseMapper.toDto(savedCourse);
        savedCourseDto.setModules(savedModules);
        return savedCourseDto;
    }

    private Set<ModuleDto> saveModules(Set<ModuleDto> moduleDtos, Course savedCourse) {
        Set<ModuleDto> savedModules = new HashSet<>();
        for (ModuleDto moduleDto : moduleDtos) {
            Module module = moduleMapper.toModel(moduleDto);
            module.setCourse(savedCourse);
            Module savedModule = moduleRepository.save(module);

            if (moduleDto.getWebinar() != null) {
                Webinar webinar = webinarMapper.toModel(moduleDto.getWebinar());
                webinar.setModule(savedModule);
                webinarRepository.save(webinar);
                savedModule.setWebinar(webinar);
            }

            Set<ThemaDto> themas = moduleDto.getThemas();
            Set<ThemaDto> savedThemas = saveThemas(themas, savedModule);

            ModuleDto savedModuleDto = moduleMapper.toDto(savedModule);
            savedModuleDto.setThemas(savedThemas);
            savedModules.add(savedModuleDto);
        }
        return savedModules;
    }

    private Set<ThemaDto> saveThemas(Set<ThemaDto> themaDtos, Module savedModule) {
        Set<ThemaDto> savedThemas = new HashSet<>();
        for (ThemaDto themaDto : themaDtos) {
            Thema thema = themaMapper.toModel(themaDto);
            thema.setModule(savedModule);
            Thema savedThema = themaRepository.save(thema);

            Set<LessonDto> lessons = themaDto.getLessons();
            Set<LessonDto> savedLessons = saveLessons(lessons, savedThema);

            ThemaDto savedThemaDto = themaMapper.toDto(savedThema);
            savedThemaDto.setLessons(savedLessons);
            savedThemas.add(savedThemaDto);
        }
        return savedThemas;
    }

    private Set<LessonDto> saveLessons(Set<LessonDto> lessonDtos, Thema savedThema) {
        Set<LessonDto> savedLessons = new HashSet<>();
        for (LessonDto lessonDto : lessonDtos) {
            Lesson lesson = lessonMapper.toModel(lessonDto);
            lesson.setThema(savedThema);
            Lesson savedLesson = lessonRepository.save(lesson);

            Set<HomeworkDto> homeworks = lessonDto.getHomeworks();
            Set<HomeworkDto> savedHomeworks = saveHomeworks(homeworks, savedLesson);

            LessonDto savedLessonDto = lessonMapper.toDto(savedLesson);
            savedLessonDto.setHomeworks(savedHomeworks);
            savedLessons.add(savedLessonDto);
        }
        return savedLessons;
    }

    private Set<HomeworkDto> saveHomeworks(Set<HomeworkDto> homeworkDtos, Lesson savedLesson) {
        Set<HomeworkDto> savedHomeworks = new HashSet<>();
        for (HomeworkDto homeworkDto : homeworkDtos) {
            Homework homework = homeworkMapper.toModel(homeworkDto);
            homework.setLesson(savedLesson);
            Homework savedHomework = homeworkRepository.save(homework);
            savedHomeworks.add(homeworkMapper.toDto(savedHomework));
        }
        return savedHomeworks;
    }
}
