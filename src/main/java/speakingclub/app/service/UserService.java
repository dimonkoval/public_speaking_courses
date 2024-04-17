package speakingclub.app.service;

import speakingclub.app.dto.course.CourseDto;
import speakingclub.app.model.Course;

import java.util.List;

public interface StudentService {
    void addCourseToStudent(Long studentId, Long courseId);
    List<Course> getCoursesByStudentId(Long Id);
}
