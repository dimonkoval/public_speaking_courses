package speakingclub.app.service;

import java.util.Set;
import speakingclub.app.dto.course.LessonDto;
import speakingclub.app.model.Thema;

public interface LessonService {
    Set<LessonDto> saveLessons(Set<LessonDto> lessonDtos, Thema savedThema);
}
