package speakingclub.app.service.impl;

import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import speakingclub.app.dto.course.HomeworkDto;
import speakingclub.app.mapper.course.HomeworkMapper;
import speakingclub.app.model.Homework;
import speakingclub.app.model.Lesson;
import speakingclub.app.repository.course.HomeworkRepository;
import speakingclub.app.service.HomeworkService;

@Service
@RequiredArgsConstructor
public class HomeworkServiceImpl implements HomeworkService {
    private final HomeworkMapper homeworkMapper;
    private final HomeworkRepository homeworkRepository;

    @Override
    public Set<HomeworkDto> saveHomeworks(Set<HomeworkDto> homeworkDtos, Lesson savedLesson) {
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
