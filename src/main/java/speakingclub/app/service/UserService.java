package speakingclub.app.service;

import speakingclub.app.dto.course.CourseDto;
import speakingclub.app.dto.course.SkillDto;
import speakingclub.app.dto.user.UserResponseDto;
import speakingclub.app.model.Course;
import speakingclub.app.model.Homework;
import speakingclub.app.model.Skill;

import java.util.List;
import java.util.Optional;

public interface UserService {
    String addCourseToStudent(Long userId, Long courseId);
    List<Course> getCoursesByUserId(Long Id);
    CourseDto getCourseByIdAndUserId(Long userId, Long courseId);
    List<Skill> getSkillsByUserId(Long id);
    List<Homework> getHomeworksByUserId(Long id);
    UserResponseDto getUserById(Long id);
}
