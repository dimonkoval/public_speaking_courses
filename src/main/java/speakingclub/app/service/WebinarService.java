package speakingclub.app.service;

import speakingclub.app.dto.course.WebinarDto;
import speakingclub.app.model.Module;

public interface WebinarService {
    WebinarDto saveWebinar(WebinarDto webinarDto, Module savedModule);
}
