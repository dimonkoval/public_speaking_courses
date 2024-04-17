package speakingclub.app.service;

import speakingclub.app.dto.course.CourseDto;
import speakingclub.app.dto.course.CourseWithCoachingDto;
import speakingclub.app.dto.course.CourseWithWebinarDto;
import speakingclub.app.model.Course;

import java.util.Arrays;
import java.util.List;

public interface CourseService {
    CourseDto saveCourse(CourseDto courseDto);

    CourseWithWebinarDto saveCourseWithWebinar(CourseWithWebinarDto courseWithWebinarDto);

    CourseWithCoachingDto saveCourseWithCoaching(CourseWithCoachingDto courseWithCoachingDto);

    List<Course> getAllCourses();

}
