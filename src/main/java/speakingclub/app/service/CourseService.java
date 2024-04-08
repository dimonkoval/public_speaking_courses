package speakingclub.app.service;

import speakingclub.app.dto.course.CourseDto;
import speakingclub.app.dto.course.CourseWithCoachingDto;
import speakingclub.app.dto.course.CourseWithWebinarDto;

public interface CourseService {
    CourseDto saveCourse(CourseDto courseDto);

    CourseWithWebinarDto saveCourseWithWebinar(CourseWithWebinarDto courseWithWebinarDto);

    CourseWithCoachingDto saveCourseWithCoaching(CourseWithCoachingDto courseWithCoachingDto);
}
