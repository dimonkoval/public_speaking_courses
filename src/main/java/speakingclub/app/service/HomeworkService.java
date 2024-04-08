package speakingclub.app.service;

import java.util.Set;
import speakingclub.app.dto.course.HomeworkDto;
import speakingclub.app.model.Lesson;

public interface HomeworkService {
    Set<HomeworkDto> saveHomeworks(Set<HomeworkDto> homeworkDtos, Lesson savedLesson);
}
