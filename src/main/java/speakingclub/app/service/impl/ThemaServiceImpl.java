package speakingclub.app.service.impl;

import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import speakingclub.app.dto.course.LessonDto;
import speakingclub.app.dto.course.ThemaDto;
import speakingclub.app.mapper.course.ThemaMapper;
import speakingclub.app.model.Module;
import speakingclub.app.model.Thema;
import speakingclub.app.repository.course.ThemaRepository;
import speakingclub.app.service.LessonService;
import speakingclub.app.service.ThemaService;

@Service
@RequiredArgsConstructor
public class ThemaServiceImpl implements ThemaService {
    private final ThemaMapper themaMapper;
    private final ThemaRepository themaRepository;
    private final LessonService lessonService;

    @Override
    public Set<ThemaDto> saveThemas(Set<ThemaDto> themaDtos, Module savedModule) {
        Set<ThemaDto> savedThemas = new HashSet<>();
        for (ThemaDto themaDto : themaDtos) {
            Thema thema = themaMapper.toModel(themaDto);
            thema.setModule(savedModule);
            Thema savedThema = themaRepository.save(thema);

            Set<LessonDto> lessons = themaDto.getLessons();
            Set<LessonDto> savedLessons = lessonService.saveLessons(lessons, savedThema);

            ThemaDto savedThemaDto = themaMapper.toDto(savedThema);
            savedThemaDto.setLessons(savedLessons);
            savedThemas.add(savedThemaDto);
        }
        return savedThemas;
    }
}
