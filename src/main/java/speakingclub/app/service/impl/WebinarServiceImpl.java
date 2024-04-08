package speakingclub.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import speakingclub.app.dto.course.WebinarDto;
import speakingclub.app.mapper.course.WebinarMapper;
import speakingclub.app.model.Module;
import speakingclub.app.model.Webinar;
import speakingclub.app.repository.course.WebinarRepository;
import speakingclub.app.service.WebinarService;

@Service
@RequiredArgsConstructor
public class WebinarServiceImpl implements WebinarService {
    private final WebinarMapper webinarMapper;
    private final WebinarRepository webinarRepository;

    @Override
    public WebinarDto saveWebinar(WebinarDto webinarDto, Module savedModule) {
        Webinar webinar = webinarMapper.toModel(webinarDto);
        webinar.setModule(savedModule);
        return webinarMapper.toDto(webinarRepository.save(webinar));
    }
}
