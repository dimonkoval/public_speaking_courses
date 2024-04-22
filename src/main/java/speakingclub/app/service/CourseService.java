package speakingclub.app.service;

import java.util.List;
import speakingclub.app.dto.course.CourseDto;
import speakingclub.app.dto.course.CourseWithCoachingDto;
import speakingclub.app.dto.course.CourseWithWebinarDto;
import speakingclub.app.model.enums.CourseDirection;
import speakingclub.app.model.enums.CourseType;

public interface CourseService {
    CourseDto saveCourse(CourseDto courseDto);

    CourseWithWebinarDto saveCourseWithWebinar(CourseWithWebinarDto courseWithWebinarDto);

    CourseWithCoachingDto saveCourseWithCoaching(CourseWithCoachingDto courseWithCoachingDto);

    List<CourseDto> getAllCourses();

    List<CourseDto> getCoursesByTypeAndDirection(CourseType type, CourseDirection direction);
}
