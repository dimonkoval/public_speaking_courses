package speakingclub.app.service.impl;

import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import speakingclub.app.dto.course.HomeworkDto;
import speakingclub.app.dto.course.LessonDto;
import speakingclub.app.mapper.course.LessonMapper;
import speakingclub.app.model.Lesson;
import speakingclub.app.model.Thema;
import speakingclub.app.repository.course.LessonRepository;
import speakingclub.app.service.HomeworkService;
import speakingclub.app.service.LessonService;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonMapper lessonMapper;
    private final LessonRepository lessonRepository;
    private final HomeworkService homeworkService;

    @Override
    public Set<LessonDto> saveLessons(Set<LessonDto> lessonDtos, Thema savedThema) {
        Set<LessonDto> savedLessons = new HashSet<>();
        for (LessonDto lessonDto : lessonDtos) {
            Lesson lesson = lessonMapper.toModel(lessonDto);
            lesson.setThema(savedThema);
            Lesson savedLesson = lessonRepository.save(lesson);

            Set<HomeworkDto> homeworks = lessonDto.getHomeworks();
            Set<HomeworkDto> savedHomeworks = homeworkService.saveHomeworks(homeworks, savedLesson);

            LessonDto savedLessonDto = lessonMapper.toDto(savedLesson);
            savedLessonDto.setHomeworks(savedHomeworks);
            savedLessons.add(savedLessonDto);
        }
        return savedLessons;
    }
}
